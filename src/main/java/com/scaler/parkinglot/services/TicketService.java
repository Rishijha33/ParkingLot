package com.scaler.parkinglot.services;

import com.scaler.parkinglot.exceptions.InvalidGateException;
import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.TicketRepository;
import com.scaler.parkinglot.strategies.spotAssignmentStrategies.RandomSpotAssignmentStrategy;
import com.scaler.parkinglot.strategies.spotAssignmentStrategies.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private VehicleService vehicleService;
    private GateService gateService;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotService parkingLotService;
    private ParkingSpotService parkingSpotService;
    private TicketRepository ticketRepository;

    //Dependency Injection Principle
    public TicketService(VehicleService vehicleService, GateService gateService,
                         SpotAssignmentStrategy spotAssignmentStrategy, ParkingLotService parkingLotService,
                         ParkingSpotService parkingSpotService, TicketRepository ticketRepository)
    {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy =spotAssignmentStrategy;
        this.parkingLotService = parkingLotService;
        this.parkingSpotService = parkingSpotService;
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(String vehicleNumber, Long gateId, VehicleType vehicleType) throws InvalidGateException {
        // actual logic will come here
        //Check if the vehicle is in the DB
        //eg - VehieleRepository.getVehicleByNumber
        //if vehicle is not there in the DB then create the vehicle and store in the DB

        //Way 1: Directly call the Vehicle Repository
        //Way 2; Call the VehicleService and it will internally call the repo -> this is better as single point of contact

        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);
        if(vehicle == null)
        {
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        Gate gate = gateService.getGate(gateId);
        if (gate == null)
        {
            //Throw an exception
            throw new InvalidGateException("The gate Id in not correct");
        }

        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setOperator(gate.getOperator());
        Long time = System.currentTimeMillis();
        ticket.setEntryTime(time); //implement this

        //Now we need to assign the parking spot
        spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingLotService); //either put an ifelse or use factory for different startegies
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignParkingSpot(vehicleType, gate);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);

        //updating in the SB
        parkingSpotService.updateParkingStatus(ParkingSpotStatus.OCCUPIED);
        ticket.setParkingSpot(parkingSpot);

        ticket = ticketRepository.saveTicket(ticket);
        return ticket;
    }
}

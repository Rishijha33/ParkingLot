package com.scaler.parkinglot.strategies.spotAssignmentStrategies;


import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.services.ParkingLotService;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    private ParkingLotService parkingLotService;

    public RandomSpotAssignmentStrategy(ParkingLotService parkingLotService)
    {
        this.parkingLotService = parkingLotService;
    }
    @Override
    public ParkingSpot assignParkingSpot(VehicleType vehicleType, Gate gate) {
        //get the parking lot from the GateId
        ParkingLot parkingLot = parkingLotService.getParkingLot(gate.getId());
        //get the list of parking lot from the parking lot
        List<ParkingSpot> parkingSpots = parkingLotService.getParkingSpots(parkingLot.getId());

        //
        for(ParkingSpot parkingSpot : parkingSpots)
        {   //checking if the parking spot is available and it supports the given vehicle type
            if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
                    parkingSpot.getSupportedVehicleTypes().contains(vehicleType))
            {
                return parkingSpot;
            }
        }
        return null;
    }
}

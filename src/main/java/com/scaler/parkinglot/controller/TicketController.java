package com.scaler.parkinglot.controller;

import com.scaler.parkinglot.dto.GenerateTicketRequestDto;
import com.scaler.parkinglot.dto.GenerateTicketResponseDto;
import com.scaler.parkinglot.exceptions.InvalidGateException;
import com.scaler.parkinglot.models.Gate;
import com.scaler.parkinglot.models.GenerateTicketResponseStatus;
import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.models.Vehicle;
import com.scaler.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController()
    {}
    public TicketController(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }


    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto dto)
    {
        /*
        Steps
        take vehicleNo and gateId in input
        1. Get the vehicle details using vehicleNo
            -if the details are in DB then fetch the object
            -if not the make a new object and store it
         */
        Ticket ticket = null;
        try {
            ticket = ticketService.generateTicket(dto.getVehicleNumber(), dto.getGateId(), dto.getVehicleType());
        } catch (InvalidGateException e) {
            throw new RuntimeException(e);
        }

        GenerateTicketResponseDto ticketResponseDto = new GenerateTicketResponseDto();
        ticketResponseDto.setTicket(ticket);
        ticketResponseDto.setGenerateTicketResponseStatus(GenerateTicketResponseStatus.SUCCESS); //setting the response status as success

        return ticketResponseDto;


    }



    //DTO -> data transfer objects
    //using these DTOs we are passing the restrictive information to the client (here the operator that will generate the ticket)
}

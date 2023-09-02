package com.scaler.parkinglot;

import com.scaler.parkinglot.controller.TicketController;
import com.scaler.parkinglot.dto.GenerateTicketRequestDto;
import com.scaler.parkinglot.dto.GenerateTicketResponseDto;
import com.scaler.parkinglot.models.Ticket;

import java.util.Scanner;

public class ParkingLotMain {

    //BaseModel -> id attribute is preset in the basemodel class hence every model having the id attribute extends it
    // 1. Create controller, service and repository for each model (wherever required)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketController ticketController = new TicketController();
        //Taking the input
        System.out.println("Please enter the Vehicle number");
        String vehicleNumber = scanner.next();

        System.out.println("Please enter the GateId");
        Long gateId = scanner.nextLong();
        GenerateTicketRequestDto generateTicketRequestDto = new GenerateTicketRequestDto(vehicleNumber, gateId);
        GenerateTicketResponseDto generateTicketResponseDto = ticketController.generateTicket(generateTicketRequestDto);

        Ticket ticket = generateTicketResponseDto.getTicket();

        System.out.println("Ticket Generated");
        System.out.println("Debug");
    }

}

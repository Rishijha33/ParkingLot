package com.scaler.parkinglot.dto;

import com.scaler.parkinglot.models.GenerateTicketResponseStatus;
import com.scaler.parkinglot.models.Ticket;

public class GenerateTicketResponseDto {
    private Ticket ticket;
    private GenerateTicketResponseStatus generateTicketResponseStatus;

    public GenerateTicketResponseStatus getGenerateTicketResponseStatus() {

        return generateTicketResponseStatus;
    }

    public void setGenerateTicketResponseStatus(GenerateTicketResponseStatus generateTicketResponseStatus) {
        this.generateTicketResponseStatus = generateTicketResponseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}

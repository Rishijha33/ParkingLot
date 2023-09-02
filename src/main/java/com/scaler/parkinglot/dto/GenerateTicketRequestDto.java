package com.scaler.parkinglot.dto;

import com.scaler.parkinglot.models.VehicleType;

public class GenerateTicketRequestDto {
    private String vehicleNumber;
    private Long gateId;

    public GenerateTicketRequestDto(String vehicleNumber, Long gateId)
    {
        this.vehicleNumber = vehicleNumber;
        this.gateId = gateId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    private VehicleType vehicleType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }
}

package com.scaler.parkinglot.models;

public class ElectricParkingSpot extends ParkingSpot{
    private ElectricMeter electricMeter;

    public ElectricMeter getElectricMeter() {
        return electricMeter;
    }

    public void setElectricMeter(ElectricMeter electricMeter) {
        this.electricMeter = electricMeter;
    }
}

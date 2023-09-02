package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.ParkingSpotStatus;

public class ParkingSpotService {
    public void updateParkingStatus(ParkingSpotStatus parkingSpotStatus)
    {
        System.out.print("Parking spot marked as "+parkingSpotStatus);
    }

}

package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.repositories.ParkingLotRepository;

import java.util.List;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository)
    {
        this.parkingLotRepository = parkingLotRepository;
    }
    public List<ParkingSpot> getParkingSpots(Long parkingLotId)
    {
        return null;
    }

    public ParkingLot getParkingLot(Long gateId)
    {
        return parkingLotRepository.getParkingLot(gateId);

    }
}

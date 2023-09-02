package com.scaler.parkinglot.strategies.spotAssignmentStrategies;

import com.scaler.parkinglot.models.Gate;
import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignParkingSpot(VehicleType vehicleType, Gate gate);
}

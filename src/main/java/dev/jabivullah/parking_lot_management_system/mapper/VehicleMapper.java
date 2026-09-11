package dev.jabivullah.parking_lot_management_system.mapper;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.entity.Vehicle;

public class VehicleMapper {
    public static Vehicle vehicleToEntity(TicketRequestDto ticketRequestDto){
        Vehicle vehicle = new Vehicle();
        vehicle.setNumber(ticketRequestDto.getVechicleNumber());
        vehicle.setVehicleType(ticketRequestDto.getVechicleType());
        return vehicle;
    }
}

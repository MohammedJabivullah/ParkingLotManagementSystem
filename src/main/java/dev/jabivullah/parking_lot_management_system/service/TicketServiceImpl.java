package dev.jabivullah.parking_lot_management_system.service;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.dto.TicketResponceDto;
import dev.jabivullah.parking_lot_management_system.entity.ParkingLot;
import dev.jabivullah.parking_lot_management_system.entity.ParkingSpot;
import dev.jabivullah.parking_lot_management_system.entity.Vehicle;
import dev.jabivullah.parking_lot_management_system.exception.parkingLotException.ParkingLotNotFoundException;
import dev.jabivullah.parking_lot_management_system.mapper.VehicleMapper;
import dev.jabivullah.parking_lot_management_system.repository.ParkingLotRepository;
import dev.jabivullah.parking_lot_management_system.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.*;

public class TicketServiceImpl implements TicketService{
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    ParkingSpotServiceImpl parkingSpotService;


    @Override
    public TicketResponceDto creatTicket(TicketRequestDto ticketRequestDto) {
        // creates a uniqe ticket id by using Time, Vehicle No., GateId, OperaterId

        // Selecting Lot by GateId/GateCode where gateId/gateCode containes Lot Code eg:- L1G2 L1 is Lot Code
        ParkingLot parkingLot = parkingLotRepository.findByParkingLotCode(ticketRequestDto.getGateId().substring(0, 2)).orElseThrow(() -> new ParkingLotNotFoundException("ParkingLot with id:" + ticketRequestDto.getGateId().substring(0, 2) + " Not Found!"));

        //ParkingSpot spot = parkingSpotService.getParkingSpot(ticketRequestDto.getGateId(), );

        // find Vehicle from Repository or Create the vehicle (if not present)
        Vehicle vehicle = vehicleRepository.findByNumber(ticketRequestDto.getVechicleNumber()).orElseGet(() -> vehicleRepository.save(VehicleMapper.vehicleToEntity(ticketRequestDto)));


//                vechicleRepository.findByNumber(info.getVechicleNumber())
        return null;
    }

    public String generateId(String number, Instant time){
        return "UnderProcess";
    }
}

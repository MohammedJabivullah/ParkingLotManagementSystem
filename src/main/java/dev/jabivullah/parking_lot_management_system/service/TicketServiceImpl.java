package dev.jabivullah.parking_lot_management_system.service;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.dto.TicketResponceDto;
import dev.jabivullah.parking_lot_management_system.entity.Vehicle;
import dev.jabivullah.parking_lot_management_system.mapper.VehicleMapper;
import dev.jabivullah.parking_lot_management_system.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class TicketServiceImpl implements TicketService{
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public TicketResponceDto creatTicket(TicketRequestDto ticketRequestDto) {

        private static final DateTimeFormatter dateTimeFormat;
        dateTimeFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC);
        // creates a uniqe ticket id by using Time, Vehicle No., GateId, OperaterId

        // find Vehicle from Repository or Create the vehicle (if not present)
        Vehicle vehicle = vehicleRepository.findByNumber(ticketRequestDto.getVechicleNumber());
        if(vehicle == null){
            vehicle = vehicleRepository.save(VehicleMapper.vehicleToEntity(ticketRequestDto));
        }

//                vechicleRepository.findByNumber(info.getVechicleNumber())
        return null;
    }

    public String generateId(String number, Instant time){
        return "UnderProcess";
    }
}

package dev.jabivullah.parking_lot_management_system.service.ticket;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.dto.TicketResponseDto;
import dev.jabivullah.parking_lot_management_system.entity.*;
import dev.jabivullah.parking_lot_management_system.exception.ticketException.GateNotFoundException;
import dev.jabivullah.parking_lot_management_system.exception.ticketException.OperatorNotFoundException;
import dev.jabivullah.parking_lot_management_system.exception.ticketException.ParkingLotNotFoundException;
import dev.jabivullah.parking_lot_management_system.mapper.VehicleMapper;
import dev.jabivullah.parking_lot_management_system.repository.*;
import dev.jabivullah.parking_lot_management_system.service.parkingspot.ParkingSpotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TicketServiceImpl implements TicketService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private GateRepository gateRepository;
    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ParkingSpotServiceImpl parkingSpotService;


    @Override
    public TicketResponseDto creatTicket(TicketRequestDto ticketRequestDto) {
        // Finding parking lot from gate ID
        ParkingLot parkingLot = parkingLotRepository
                .findByParkingLotCode(ticketRequestDto.getGateId().substring(0, 2))
                .orElseThrow(() -> new ParkingLotNotFoundException("There is no Parking Lot with id:" + ticketRequestDto.getGateId().substring(0, 2)));

        // Assigning parking spot
        ParkingSpot parkingSpot = parkingSpotService.getParkingSpot(parkingLot, ticketRequestDto.getVechicleType());

        // Finding/Assigning Gate
        Gate gate = gateRepository.findByGateCode(ticketRequestDto.getGateId()).orElseThrow(() -> new GateNotFoundException("There is no Gate with id:"+ticketRequestDto.getGateId()));

        // Finding if vehicle exist or create/save as new one
        Vehicle vehicle = vehicleRepository
                .findByNumber(ticketRequestDto.getVechicleNumber())
                .orElseGet(() -> vehicleRepository.save(VehicleMapper.vehicleToEntity(ticketRequestDto)));

        //Creating ticket and unique ticketId
        Instant dateTime = Instant.now();

        //Finding Operator
        Operator operator = operatorRepository.findByOperatorId(ticketRequestDto.getOperatorId()).orElseThrow(() -> new OperatorNotFoundException("There is no Operator with id:"+ticketRequestDto.getOperatorId()));

        String ticketCode = generateTicketCode(ticketRequestDto.getVechicleNumber(), dateTime);

        Ticket ticket = new Ticket();
        ticket.setTicketCode(ticketCode);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(dateTime);
        ticket.setDate(DateTimeFormatter.ofPattern("ddMMyyyy").withZone(ZoneId.of("Asia/Kolkata")).format(dateTime));
        ticket.setParkingSpot(parkingSpot);
        ticket.setGate(gate);
        ticket.setOperator(operator);

        ticketRepository.save(ticket);

        TicketResponseDto ticketResponse = new TicketResponseDto();
        ticketResponse.setTicketId(ticketCode);
        ticketResponse.setDateTime(DateTimeFormatter.ofPattern("HH:mm:ss-dd/MM/yyyy").withZone(ZoneId.of("Asia/Kolkata")).format(dateTime));


        //

        return null;
    }

    public String generateTicketCode(String number, Instant dateTime){
        DateTimeFormatter dateTimeFormat = DateTimeFormatter
                .ofPattern("ssmmHHddMMyyyy")
                .withZone(ZoneId.of("Asia/Kolkata"));

        String ticketCode;
        ticketCode = number+"-"+dateTimeFormat.format(dateTime);

        return ticketCode;
    }
}

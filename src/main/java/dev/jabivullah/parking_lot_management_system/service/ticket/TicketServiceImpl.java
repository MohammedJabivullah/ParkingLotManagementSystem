package dev.jabivullah.parking_lot_management_system.service.ticket;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.dto.TicketResponseDto;
import dev.jabivullah.parking_lot_management_system.entity.*;
import dev.jabivullah.parking_lot_management_system.exception.invalid.InvalidGateException;
import dev.jabivullah.parking_lot_management_system.exception.invalid.InvalidOperatorException;
import dev.jabivullah.parking_lot_management_system.exception.invalid.InvalidParkingLotException;
import dev.jabivullah.parking_lot_management_system.exception.notfound.TicketNotFoundException;
import dev.jabivullah.parking_lot_management_system.mapper.VehicleMapper;
import dev.jabivullah.parking_lot_management_system.mapper.responsemapper.TicketToTicketResponseMapper;
import dev.jabivullah.parking_lot_management_system.repository.*;
import dev.jabivullah.parking_lot_management_system.service.parkingspot.ParkingSpotService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final VehicleRepository vehicleRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final GateRepository gateRepository;
    private final OperatorRepository operatorRepository;
    private final TicketRepository ticketRepository;

    private final ParkingSpotService parkingSpotService;

    public TicketServiceImpl(VehicleRepository vehicleRepository,
                             ParkingLotRepository parkingLotRepository,
                             GateRepository gateRepository,
                             OperatorRepository operatorRepository,
                             TicketRepository ticketRepository,
                             ParkingSpotService parkingSpotService){
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.operatorRepository = operatorRepository;
        this.ticketRepository = ticketRepository;
        this.parkingSpotService = parkingSpotService;
    }



    @Override
    public TicketResponseDto createTicket(TicketRequestDto ticketRequestDto) {
        // Finding parking lot from gate ID
        ParkingLot parkingLot = parkingLotRepository
                .findByParkingLotCode(ticketRequestDto.getGateId().substring(0, 2))
                .orElseThrow(() -> new InvalidParkingLotException("Invalid ParkingLot ID:" + ticketRequestDto.getGateId().substring(0, 2)));

        // Finding/Assigning Gate
        Gate gate = gateRepository.findByGateCode(ticketRequestDto.getGateId()).orElseThrow(() -> new InvalidGateException("Invalid Gate ID:"+ticketRequestDto.getGateId()));

        //Finding Operator
        Operator operator = operatorRepository
                .findByOperatorId(ticketRequestDto.getOperatorId())
                .orElseThrow(() -> new InvalidOperatorException("Invalid Operator ID:"+ticketRequestDto.getOperatorId()));

        // Finding if vehicle exist or create/save as new one
        Vehicle vehicle = vehicleRepository
                .findByNumber(ticketRequestDto.getVechicleNumber())
                .orElseGet(() -> vehicleRepository.save(VehicleMapper.vehicleToEntity(ticketRequestDto)));

        // Assigning parking spot
        ParkingSpot parkingSpot = parkingSpotService.getParkingSpot(parkingLot, ticketRequestDto.getVechicleType());

        //Creating ticket and unique ticketId
        Instant dateTime = Instant.now();

        // Creating a uniqe TicketId which will be printed on ticket
        String ticketCode = generateTicketCode(ticketRequestDto.getVechicleNumber(), dateTime);

        Ticket ticket = new Ticket();
        ticket.setTicketCode(ticketCode);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(dateTime);
        ticket.setDate(DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("Asia/Kolkata")).format(dateTime));
        ticket.setParkingSpot(parkingSpot);
        ticket.setGate(gate);
        ticket.setOperator(operator);

        // Saving Ticket in DB
        ticketRepository.save(ticket);

        TicketResponseDto ticketResponse = TicketToTicketResponseMapper.ticketToTicketResponseDto(ticket);
        // API response
        return ticketResponse;
    }

    @Override
    public TicketResponseDto getTicketByCode(String ticketCode){
        Ticket ticket = ticketRepository.findByTicketCode(ticketCode).orElseThrow(
                () -> new TicketNotFoundException("Tickets with ID:"+ticketCode+" Not Found")
        );
        return TicketToTicketResponseMapper.ticketToTicketResponseDto(ticket);
    }

    @Override
    public List<TicketResponseDto> getTicketsByDate(String date){
        List<TicketResponseDto> responseDtoList = new ArrayList<>();

        List<Ticket> tickets = ticketRepository.findByDate(date).orElseThrow(
                () -> new TicketNotFoundException("Tickets with "+date+" Not Found")
        );

        for(Ticket t : tickets){
            responseDtoList.add(TicketToTicketResponseMapper.ticketToTicketResponseDto(t));
        }
        return responseDtoList;
    }

    private String generateTicketCode(String number, Instant dateTime){
        DateTimeFormatter dateTimeFormat = DateTimeFormatter
                .ofPattern("ssmmHHddMMyyyy")
                .withZone(ZoneId.of("Asia/Kolkata"));

        String ticketCode;
        ticketCode = number+"-"+dateTimeFormat.format(dateTime);

        return ticketCode;
    }
}

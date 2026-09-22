package dev.jabivullah.parking_lot_management_system.mapper.responsemapper;

import dev.jabivullah.parking_lot_management_system.dto.TicketResponseDto;
import dev.jabivullah.parking_lot_management_system.entity.Ticket;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TicketToTicketResponseMapper {
    public static TicketResponseDto ticketToTicketResponseDto(Ticket ticket){
        TicketResponseDto response = new TicketResponseDto();
        response.setTicketId(ticket.getTicketCode());
        response.setDate(ticket.getDate());
        response.setTime(DateTimeFormatter.ofPattern("HH:mm:ss")
                .withZone(ZoneId.of("Asia/Kolkata"))
                .format(ticket.getEntryTime()));
        response.setParkingSpotCode(ticket.getParkingSpot().getSpotCode());
        response.setFloorNumber(ticket.getParkingSpot().getParkingFloor().getFloorNumber());

        return response;
    }
}
/*
TicketResponseDto               Ticket
    private String ticketId;    private String ticketCode;
    private String date;        private String date;
    private String time;        private Instant entryTime; // have to convert to String IST = DateTimeFormatter.ofPattern("HH:mm:ss")
                                                                                                .withZone(ZoneId.of("Asia/Kolkata"))
                                                                                                .format(Instant entryTime))
    private String parkingSpotCode;    private ParkingSpot parkingSpot; // Spot.getCode = parkingSpot.getSpotCode()
    private int floorNumber;           // floor = parkingSpot.getParkingFloor().getFloorNumber()

Ticket
    private String ticketCode;
    private Instant entryTime;
    private String date;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Gate gate;
    private Operator operator;

        ticketResponse.setTicketId(ticketCode);
        ticketResponse.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy")
                .withZone(ZoneId.of("Asia/Kolkata"))
                .format(dateTime));
        ticketResponse.setTime(DateTimeFormatter.ofPattern("HH:mm:ss")
                .withZone(ZoneId.of("Asia/Kolkata"))
                .format(dateTime));
        ticketResponse.setParkingSpotCode(parkingSpot.getSpotCode());
        ticketResponse.setFloorNumber(parkingSpot.getParkingFloor().getFloorNumber());
 */

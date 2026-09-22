package dev.jabivullah.parking_lot_management_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResponseDto {
    private String ticketId;
    private String date;
    private String time;
    private String parkingSpotCode;
    private int floorNumber;
}
/*
Response JSON
{
  "ticketId": .....,
  "dateTime": "14/09/2026",
  "time":  "20:01:01",
  "spotNumber": ...,
  "floorNumber": ..,
}
 */

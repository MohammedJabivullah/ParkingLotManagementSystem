package dev.jabivullah.parking_lot_management_system.dto;

import dev.jabivullah.parking_lot_management_system.entity.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResponceDto {
    private Ticket ticket;
    private ResponceStatus responceStatus;
}

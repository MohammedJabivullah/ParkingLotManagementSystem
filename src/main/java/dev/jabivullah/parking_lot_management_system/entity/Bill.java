package dev.jabivullah.parking_lot_management_system.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
public class Bill extends BaseEntity{
    private Instant exitTime;
    private int amount;
    private String ticketId;
    private Operator operator;
    private BillStatus billStatus;
    private List<Payment> payments;
}

package dev.jabivullah.parking_lot_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseEntity{
    private int amount;
    private Instant time;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    private String referenceNumber;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
}

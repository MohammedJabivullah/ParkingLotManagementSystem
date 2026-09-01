package dev.jabivullah.parking_lot_management_system.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Payment extends BaseEntity{
    private int amount;
    private Date time;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    private String referenceNumber;
}

package dev.jabivullah.parking_lot_management_system.entity;

import java.util.Date;
import java.util.List;

public class Bill extends BaseEntity{
    private Date exitTime;
    private int amount;
    private Ticket ticket;
    private Operator operator;
    private BillStatus billStatus;
    private List<Payment> payments;
}

package dev.jabivullah.parking_lot_management_system.entity;

import jakarta.persistence.*;
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
    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "operator_id")
    private Operator operator;
    @ManyToOne
    @JoinColumn(name = "gate_id")
    private Gate gate;
    @Enumerated(EnumType.STRING)
    private BillStatus billStatus;
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<Payment> payments;
}

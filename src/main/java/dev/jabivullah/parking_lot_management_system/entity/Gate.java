package dev.jabivullah.parking_lot_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Gate extends BaseEntity{
    private String gateCode;
    @Enumerated(EnumType.STRING)
    private GateType gateType;
    @Enumerated(EnumType.STRING)
    private GateStatus gateStatus;
    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;
}

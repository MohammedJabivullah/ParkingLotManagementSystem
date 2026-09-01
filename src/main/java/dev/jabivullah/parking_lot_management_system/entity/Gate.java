package dev.jabivullah.parking_lot_management_system.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Gate extends BaseEntity{
    private int gateNumber;
    private Operator operator;
    private GateType gateType;
    private GateStatus gateStatus;
    private ParkingLot parkingLot;
}

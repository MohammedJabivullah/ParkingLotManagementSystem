package dev.jabivullah.parking_lot_management_system.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseEntity{
    private String number;
    private VechicleType vehicleType;
    private String ownerName;
}

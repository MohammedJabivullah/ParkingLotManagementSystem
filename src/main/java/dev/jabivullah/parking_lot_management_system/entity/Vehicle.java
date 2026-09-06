package dev.jabivullah.parking_lot_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vehicle extends BaseEntity{
    private String number;
    private String ownerName;
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
}

package dev.jabivullah.parking_lot_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class ParkingLot extends BaseEntity{
    private String parkingLotCode;
    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<ParkingFloor> parkingFloors;
    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<Gate> gates;
    @Enumerated(EnumType.STRING)
    private ParkingSpotStatus parkingLotStatus;
}

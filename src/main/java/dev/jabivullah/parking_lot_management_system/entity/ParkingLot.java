package dev.jabivullah.parking_lot_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class ParkingLot extends BaseEntity{
    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<ParkingFloor> parkingFloors;
    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<Gate> gates;
    @ElementCollection(targetClass = VehicleType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "parking_lot_supported_vehicle_type", joinColumns = @JoinColumn(name = "parking_lot_id"))
    @Column(name = "vehicle_type")
    private List<VehicleType> supportedVechicleTypes;
    @Enumerated(EnumType.STRING)
    private ParkingSpotStatus parkingLotStatus;
}

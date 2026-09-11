package dev.jabivullah.parking_lot_management_system.repository;

import dev.jabivullah.parking_lot_management_system.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, UUID> {
    Optional<ParkingLot> findByParkingLotCode(String parkingLotCode);
}

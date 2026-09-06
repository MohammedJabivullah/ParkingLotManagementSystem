package dev.jabivullah.parking_lot_management_system.repository;

import dev.jabivullah.parking_lot_management_system.entity.Ticket;
import dev.jabivullah.parking_lot_management_system.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    Vehicle findByNumber(String number);
}

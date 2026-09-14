package dev.jabivullah.parking_lot_management_system.repository;

import dev.jabivullah.parking_lot_management_system.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OperatorRepository extends JpaRepository<Operator, UUID> {
    Optional<Operator> findByOperatorId(String operatorId);
}

package dev.jabivullah.parking_lot_management_system.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Operator extends BaseEntity{
    private String name;
    private String phoneNumber;
    private int empId;
}

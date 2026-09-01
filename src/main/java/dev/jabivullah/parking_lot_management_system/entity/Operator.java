package dev.jabivullah.parking_lot_management_system.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Operator extends BaseEntity{
    private String name;
    private String phoneNumber;
    private int empId;
}

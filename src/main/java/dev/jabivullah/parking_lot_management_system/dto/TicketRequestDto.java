package dev.jabivullah.parking_lot_management_system.dto;

import dev.jabivullah.parking_lot_management_system.entity.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Getter
@Setter
public class TicketRequestDto {
    private String vechicleNumber;
    private String ownerName;
    private VehicleType vechicleType;
    private String gateNumber;
    private Long operatorId;
}

/*
JSON
{
  "vechicleNumber": "HR10CM2038",
  "ownerName": "Kuro",
  "vechicleType": "SUV",  (->enum)
  "time": "2026-09-02T11:40:10.123456Z",  (->yyyy-MM-dd'T'HH:mm:ss.SSSX)
  "gateId": "FAG2",  (-> F-Floar A-floar alphabet and G-Gate 2-gate number)
  "opeeratorId": 748373
}
*/


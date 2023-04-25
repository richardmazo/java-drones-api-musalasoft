package co.com.musala.api.drone;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class DroneApi {
    private Long id;
    private String serialNumber;
    private String model;
    private Double weightLimit;
    private Double batteryCapacity;
    private String state;
}

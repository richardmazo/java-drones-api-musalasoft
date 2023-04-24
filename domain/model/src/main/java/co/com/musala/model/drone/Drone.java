package co.com.musala.model.drone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor

public class Drone {
    private Long id;
    private final String serialNumber;
    private final String model;
    private final Double weightLimit;
    private final BigDecimal batteryCapacity;
    private final String state;
}

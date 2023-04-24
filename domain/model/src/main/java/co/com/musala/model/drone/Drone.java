package co.com.musala.model.drone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor

public class Drone {

    private final String serialNumber;
    private final String model;
    private final Double weightLimit;
    private final String batteryCapacity;
    private final String state;
}

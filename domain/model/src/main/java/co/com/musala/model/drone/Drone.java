package co.com.musala.model.drone;

import co.com.musala.model.medication.Medication;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Drone {
    private Long id;
    private String serialNumber;
    private String model;
    private Double weightLimit;
    private Double batteryCapacity;
    private String state;
    private List<Medication> medicationList;
}

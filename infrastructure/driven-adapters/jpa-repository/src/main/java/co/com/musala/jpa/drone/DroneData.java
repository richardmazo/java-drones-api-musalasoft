package co.com.musala.jpa.drone;

import co.com.musala.jpa.medication.MedicationData;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "TBL_DRONE")
public class DroneData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name="SERIAL_NUMBER",length = 100)
    private String serialNumber;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "WEIGHT_LIMIT")
    private Double weightLimit;

    @Column(name="BATTERY_CAPACITY")
    private Double batteryCapacity;

    @Column(name = "STATE", length = 10)
    private String state;

    @OneToMany(mappedBy = "droneData", cascade = CascadeType.ALL)
    private List<MedicationData> medicationList;

}

package co.com.musala.jpa.drone;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

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
}

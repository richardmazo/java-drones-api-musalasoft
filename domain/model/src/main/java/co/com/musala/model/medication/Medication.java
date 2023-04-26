package co.com.musala.model.medication;

import co.com.musala.model.drone.Drone;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Medication {
    private Long id;
    private String name;
    private Double weight;
    private String code;
    private String image;
    private Long idDrone;
}

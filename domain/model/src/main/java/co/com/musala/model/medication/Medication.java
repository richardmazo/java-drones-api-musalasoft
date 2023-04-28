package co.com.musala.model.medication;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

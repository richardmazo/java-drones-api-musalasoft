package co.com.musala.model.medication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class Medication {
    private Long id;
    private final String name;
    private final Double weight;
    private final String code;
    private final String image;
}

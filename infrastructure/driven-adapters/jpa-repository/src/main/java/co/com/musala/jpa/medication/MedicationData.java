package co.com.musala.jpa.medication;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "TBL_MEDICATION")
public class MedicationData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name="CODE")
    private String code;

    @Column(name = "IMAGE")
    private String image;

}

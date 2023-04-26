package co.com.musala.api.medication;

import co.com.musala.model.medication.Medication;
import co.com.musala.usecase.MedicationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MedicationService {

    private final MedicationUseCase medicationUseCase;

    @GetMapping("/getMedications")
    public ResponseEntity<List<Medication>> getMedications(){
        List<Medication> responseList = medicationUseCase.getAllMedications();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Medication>> getMedicationsByIdDrone(@RequestParam("idDrone") Long idDrone){
        List<Medication> responseList = medicationUseCase.getMedicationsByIdDrone(idDrone);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

}

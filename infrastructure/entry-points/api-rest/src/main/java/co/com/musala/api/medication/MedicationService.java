package co.com.musala.api.medication;

import co.com.musala.model.medication.Medication;
import co.com.musala.usecase.MedicationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/medications", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MedicationService {

    private final MedicationUseCase medicationUseCase;

    @GetMapping
    public ResponseEntity getMedications(){
        List<Medication> responseList = medicationUseCase.getAllMedications();
        return new ResponseEntity(responseList, HttpStatus.OK);
    }
}

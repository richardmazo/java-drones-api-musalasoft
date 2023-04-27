package co.com.musala.api.medication;

import co.com.musala.api.ErrorMessage;
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
    public ResponseEntity<?> getMedications(){
        List<Medication> responseList = medicationUseCase.getAllMedications();
        if(responseList == null || responseList.isEmpty()){
            return new ResponseEntity<>(new ErrorMessage("There are no medications"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/getMedicationsByIdDrone")
    public ResponseEntity<?> getMedicationsByIdDrone(@RequestParam("idDrone") Long idDrone){
        List<Medication> responseList = medicationUseCase.getMedicationsByIdDrone(idDrone);
        if(responseList == null || responseList.isEmpty()){
            return new ResponseEntity<>(new ErrorMessage("The are no medications loaded for the drone with id " + idDrone), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

}

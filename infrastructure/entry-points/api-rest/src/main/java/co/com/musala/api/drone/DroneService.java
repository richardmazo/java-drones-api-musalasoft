package co.com.musala.api.drone;

import co.com.musala.model.drone.Drone;
import co.com.musala.model.medication.Medication;
import co.com.musala.usecase.DroneUseCase;
import co.com.musala.usecase.MedicationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DroneService {

    private final DroneUseCase droneUseCase;
    private final MedicationUseCase medicationUseCase;

    @GetMapping("/getDrones")
    public ResponseEntity<List<Drone>> getDrones(){
        List<Drone> responseList = droneUseCase.getAllDrones();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drone> updateDroneWithMedications(@PathVariable Long id, @RequestBody Drone drone) {
        Drone droneResult = droneUseCase.findById(id);
        if(droneResult!=null){
            droneResult.setMedicationList(drone.getMedicationList());
            droneResult.setBatteryCapacity(drone.getBatteryCapacity());
            List<Medication> medicationUpdateList = new ArrayList<>();
            for (Medication medication : drone.getMedicationList()) {
                //medicationUseCase.deleteMedicationById(medication.getId());
                Medication medicationUpdate = medicationUseCase.saveMedication(medication);
                medicationUpdateList.add(medicationUpdate);
            }
            Drone droneUpdate =  droneUseCase.saveDrone(droneResult);
            droneUpdate.setMedicationList(medicationUpdateList);
            return new ResponseEntity<>(droneUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(droneUseCase.saveDrone(drone), HttpStatus.NOT_FOUND);
    }


    @PostMapping("/createDrone")
    public ResponseEntity<Drone> saveDrone(@RequestBody Drone drone){
        return new ResponseEntity<>(droneUseCase.saveDrone(drone), HttpStatus.OK);
    }

    @GetMapping("/droneBattery")
    public ResponseEntity<Double> checkDroneBattery(@RequestParam("idDrone") Long idDrone){
        Drone responseList = droneUseCase.findById(idDrone);
        return new ResponseEntity<>(responseList.getBatteryCapacity(), HttpStatus.OK);
    }

}

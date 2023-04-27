package co.com.musala.api.drone;

import co.com.musala.api.ErrorMessage;
import co.com.musala.model.drone.Drone;
import co.com.musala.usecase.DroneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DroneService {

    private final DroneUseCase droneUseCase;

    @GetMapping("/getDrones")
    public ResponseEntity<?> getDrones(){
        List<Drone> responseList = droneUseCase.getAllDrones();
        if(responseList == null || responseList.isEmpty()){
            return new ResponseEntity<>(new ErrorMessage("There are no drones"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @PutMapping("updateDroneWithMedications/{id}")
    public ResponseEntity<?> updateDroneWithMedications(@PathVariable Long id, @RequestBody Drone drone) {
        Drone droneConsulted = droneUseCase.findById(id);
        if(droneConsulted!=null && drone.getMedicationList()!=null && !drone.getMedicationList().isEmpty()){
            try{
            Drone droneUpdate = droneUseCase.updateDrone(drone);
            return new ResponseEntity<>(droneUpdate, HttpStatus.OK);
            } catch (IllegalArgumentException e) {
                ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
                return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
            }
        }
        ErrorMessage errorMessage = new ErrorMessage("The drone with id " + id + " doesn't exist, or the medications list is empty, review");
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }


    @PostMapping("/createDrone")
    public ResponseEntity<?> saveDrone(@RequestBody Drone drone){
        try{
            Drone droneCreated = droneUseCase.saveDrone(drone);
            return new ResponseEntity<>(droneCreated, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/droneBattery")
    public ResponseEntity<?> checkDroneBattery(@RequestParam("idDrone") Long idDrone){
        Drone responseList = droneUseCase.findById(idDrone);
        if(responseList == null){
            return new ResponseEntity<>(new ErrorMessage("The drone with id " + idDrone + " doesn't exist"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseList.getBatteryCapacity(), HttpStatus.OK);
    }

    @GetMapping("/checkDroneAvailable")
    public ResponseEntity<?> checkDroneAvailable(){
        List<Drone> responseList = droneUseCase.findByAvailability();
        if(responseList == null || responseList.isEmpty()){
            return new ResponseEntity<>(new ErrorMessage("There are no drones available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

}

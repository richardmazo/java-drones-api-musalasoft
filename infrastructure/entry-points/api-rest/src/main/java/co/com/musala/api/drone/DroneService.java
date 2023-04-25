package co.com.musala.api.drone;

import co.com.musala.model.drone.Drone;
import co.com.musala.usecase.DroneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DroneService {

    private final DroneUseCase droneUseCase;

    @GetMapping("/getDrones")
    public ResponseEntity<List<Drone>> getDrones(){
        List<Drone> responseList = droneUseCase.getAllDrones();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
    @PostMapping("/createDrone")
    public ResponseEntity<DroneApi> saveDrone(@RequestBody DroneApi droneApi){
        droneUseCase.saveDrone(
                droneApi.getSerialNumber(),
                droneApi.getModel(),
                droneApi.getWeightLimit(),
                droneApi.getBatteryCapacity(),
                droneApi.getState()
        );
        return ResponseEntity.ok().build();
    }

}

package co.com.musala.api.drone;

import co.com.musala.model.drone.Drone;
import co.com.musala.usecase.DroneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/api/drones", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DroneService {

    private final DroneUseCase droneUseCase;

    @GetMapping
    public ResponseEntity getDrones(){
        List<Drone> responseList = droneUseCase.getAllDrones();
        return new ResponseEntity(responseList, HttpStatus.OK);
    }

}

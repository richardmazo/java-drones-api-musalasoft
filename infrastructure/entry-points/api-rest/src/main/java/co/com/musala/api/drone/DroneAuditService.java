package co.com.musala.api.drone;

import co.com.musala.model.drone.Drone;
import co.com.musala.usecase.DroneAuditUseCase;
import co.com.musala.usecase.DroneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DroneAuditService {

    private final DroneUseCase droneUseCase;
    private final DroneAuditUseCase droneAuditUseCase;

    @Scheduled(fixedRate = 180000)
    public void verifyBatteryLevel(){
        List<Drone> droneList = droneUseCase.getAllDrones();
        if(droneList !=null && !droneList.isEmpty()){
            droneAuditUseCase.registerDroneEvent(droneList);
        }
    }


}

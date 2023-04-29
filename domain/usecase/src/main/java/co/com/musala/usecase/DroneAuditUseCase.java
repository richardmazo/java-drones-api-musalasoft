package co.com.musala.usecase;

import co.com.musala.model.drone.Drone;
import co.com.musala.model.drone.gateway.DroneAuditRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DroneAuditUseCase {

    private final DroneAuditRepository droneAuditRepository;

    public void registerDroneEvent(List<Drone> droneList){
        List<Drone> dronesToUpdate = new ArrayList<>();
        for (Drone drone : droneList) {
            String state = drone.getState().toLowerCase();
            if (!state.equals("idle") && !state.equals("loading") && !state.equals("loaded") && !state.equals("delivering") && !state.equals("delivered") && !state.equals("returning")){
                drone.setState("idle");
                dronesToUpdate.add(drone);
            }
        }
        droneAuditRepository.registerDroneEvent(droneList);
    }

}

package co.com.musala.usecase;

import co.com.musala.model.drone.Drone;
import co.com.musala.model.drone.gateway.DroneRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DroneUseCase {


    private final DroneRepository droneRepository;

    public List<Drone> getAllDrones(){
        return droneRepository.findAllDrones();
    }

}

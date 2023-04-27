package co.com.musala.usecase;

import co.com.musala.model.drone.Drone;
import co.com.musala.model.drone.gateway.DroneRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DroneUseCase {


    private final DroneRepository droneRepository;

    public List<Drone> getAllDrones(){
        return droneRepository.getAllDronesWithMedications();
    }


    public Drone saveDrone(Drone drone){
        return droneRepository.saveDrone(drone);
    }

    public Drone findById(Long idDrone) {
        return droneRepository.findById(idDrone);
    }

}

package co.com.musala.usecase;

import co.com.musala.model.drone.Drone;
import co.com.musala.model.drone.gateway.DroneRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DroneUseCase {


    private final DroneRepository droneRepository;

    public List<Drone> getAllDrones(){
        return droneRepository.getAllDronesWithMedications();
    }

    public Drone saveDrone(String serialNumber, String model, Double weightLimit, Double batteryCapacity, String state){

        Drone drone = new Drone(null,serialNumber, model, weightLimit, batteryCapacity, state,null);
        return droneRepository.saveDrone(drone);
    }
}

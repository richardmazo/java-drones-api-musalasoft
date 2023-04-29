package co.com.musala.model.drone.gateway;

import co.com.musala.model.drone.Drone;

import java.util.List;

public interface DroneRepository {


    List<Drone> getAllDronesWithMedications();
    Drone saveDrone(Drone drone);
    Drone findById(Long id);


}

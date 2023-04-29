package co.com.musala.model.drone.gateway;

import co.com.musala.model.drone.Drone;

import java.util.List;

public interface DroneAuditRepository {

    void registerDroneEvent(List<Drone> droneList);

}

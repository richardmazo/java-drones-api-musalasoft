package co.com.musala.jpa.drone;

import co.com.musala.model.drone.Drone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface DroneDataRepository extends CrudRepository<DroneData, Long>,
        QueryByExampleExecutor<DroneData> {
}

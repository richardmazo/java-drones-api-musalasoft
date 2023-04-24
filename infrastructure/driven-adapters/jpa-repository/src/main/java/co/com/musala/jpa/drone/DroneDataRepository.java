package co.com.musala.jpa.drone;

import co.com.musala.model.drone.Drone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface DroneDataRepository extends CrudRepository<DroneData, Long>,
        QueryByExampleExecutor<DroneData> {

    @Query(value="SELECT * FROM Drone d WHERE d.Status = :state", nativeQuery = true)
    List<DroneData> findByState(@Param("state") String state);

}

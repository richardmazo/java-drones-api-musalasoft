package co.com.musala.jpa.drone;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface DroneDataRepository extends CrudRepository<DroneData, Long>,
        QueryByExampleExecutor<DroneData> {
    List<DroneData> findAll();
}

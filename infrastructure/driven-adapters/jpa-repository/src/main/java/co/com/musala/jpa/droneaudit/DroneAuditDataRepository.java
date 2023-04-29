package co.com.musala.jpa.droneaudit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface DroneAuditDataRepository extends CrudRepository<DroneAuditData, Long>,
        QueryByExampleExecutor<DroneAuditData> {
}

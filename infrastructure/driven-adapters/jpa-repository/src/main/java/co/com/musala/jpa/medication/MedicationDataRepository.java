package co.com.musala.jpa.medication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface MedicationDataRepository  extends CrudRepository<MedicationData, Long>,
        QueryByExampleExecutor<MedicationData> {

    List<MedicationData> findByIdDrone(Long idDrone);

}

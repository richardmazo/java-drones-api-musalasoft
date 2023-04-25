package co.com.musala.jpa.medication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface MedicationDataRepository  extends CrudRepository<MedicationData, Long>,
        QueryByExampleExecutor<MedicationData> {
}

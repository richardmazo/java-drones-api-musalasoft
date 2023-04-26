package co.com.musala.jpa.medication;

import co.com.musala.jpa.helper.AdapterOperations;
import co.com.musala.model.medication.Medication;
import co.com.musala.model.medication.gateway.MedicationRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicationRepositoryAdapter  extends AdapterOperations<Medication, MedicationData, Long, MedicationDataRepository>
        implements MedicationRepository {
    protected MedicationRepositoryAdapter(MedicationDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Medication.MedicationBuilder.class).build());
    }

    @Override
    public List<Medication> findAllMedications() {
        return super.toList(repository.findAll());
    }

    @Override
    public List<Medication> findByIdDrone(Long idDrone) {
        return toList(repository.findByIdDrone(idDrone));
    }


}

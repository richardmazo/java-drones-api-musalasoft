package co.com.musala.jpa.drone;

import co.com.musala.jpa.helper.AdapterOperations;
import co.com.musala.model.drone.Drone;
import co.com.musala.model.drone.gateway.DroneRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository
public class DroneRepositoryAdapter extends AdapterOperations<Drone, DroneData, Long, DroneDataRepository>
implements DroneRepository {
    protected DroneRepositoryAdapter(DroneDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Drone.DroneBuilder.class).build());
    }

    @Override
    public List<Drone> findAllDrones() {
        return super.findAll();
    }

    @Override
    public List<Drone> findByStatus(String status) {
        return super.toList(repository.findByState(status));
    }
}

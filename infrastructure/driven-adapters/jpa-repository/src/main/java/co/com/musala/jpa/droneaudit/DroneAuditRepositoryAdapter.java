package co.com.musala.jpa.droneaudit;

import co.com.musala.jpa.helper.AdapterOperations;
import co.com.musala.model.drone.Drone;
import co.com.musala.model.drone.gateway.DroneAuditRepository;
import jakarta.transaction.Transactional;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
public class DroneAuditRepositoryAdapter extends AdapterOperations<Drone, DroneAuditData, Long, DroneAuditDataRepository>
        implements DroneAuditRepository {
    protected DroneAuditRepositoryAdapter(DroneAuditDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Drone.DroneBuilder.class).build());
    }

    @Override
    @Transactional
    public void registerDroneEvent(List<Drone> droneList) {
        List<DroneAuditData> droneAuditDataList = new ArrayList<>();
        Date currentDate = new Date();
        for (Drone drone : droneList) {
            DroneAuditData droneData = new DroneAuditData();
            droneData.setId(drone.getId());
            droneData.setState(drone.getState());
            droneData.setModel(drone.getModel());
            droneData.setSerialNumber(drone.getSerialNumber());
            droneData.setWeightLimit(drone.getWeightLimit());
            droneData.setBatteryCapacity(drone.getBatteryCapacity());
            droneData.setEventDate(currentDate);
            droneAuditDataList.add(droneData);
        }
        super.saveData(droneAuditDataList);
    }


}

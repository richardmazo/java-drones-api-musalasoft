package co.com.musala.jpa.drone;

import co.com.musala.jpa.helper.AdapterOperations;
import co.com.musala.jpa.medication.MedicationData;
import co.com.musala.model.drone.Drone;
import co.com.musala.model.drone.gateway.DroneRepository;
import co.com.musala.model.medication.Medication;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

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
    public List<Drone> getAllDronesWithMedications() {
        List<DroneData> dronesData = repository.findAll();
        List<Drone> drones = new ArrayList<>();
        for (DroneData droneData : dronesData) {
            Drone drone = new Drone();
            drone.setId(droneData.getId());
            drone.setSerialNumber(droneData.getSerialNumber());
            drone.setModel(droneData.getModel());
            drone.setWeightLimit(droneData.getWeightLimit());
            drone.setBatteryCapacity(droneData.getBatteryCapacity());
            drone.setState(droneData.getState());
            drone.setMedicationList(toDtoList(droneData.getMedicationList()));
            drones.add(drone);
        }
        return drones;
    }

    public List<Medication> toDtoList(List<MedicationData> medicationDataList) {
        List<Medication> medicationDtoList = new ArrayList<>();
        for (MedicationData medicationData : medicationDataList) {
            Medication medicationDto = toDto(medicationData);
            medicationDtoList.add(medicationDto);
        }
        return medicationDtoList;
    }

    public Medication toDto(MedicationData medicationData) {
        Medication medication = new Medication();
        medication.setId(medicationData.getId());
        medication.setName(medicationData.getName());
        medication.setWeight(medicationData.getWeight());
        medication.setCode(medicationData.getCode());
        medication.setImage(medicationData.getImage());
        medication.setIdDrone(medicationData.getIdDrone());
        return medication;
    }



    @Override
    public List<Drone> findByStatus(String status) {
        return super.toList(repository.findByState(status));
    }

    @Override
    public Drone saveDrone(Drone drone) {
        DroneData droneData = new DroneData();
        droneData.setId(drone.getId());
        droneData.setState(drone.getState());
        droneData.setModel(drone.getModel());
        droneData.setSerialNumber(drone.getSerialNumber());
        droneData.setWeightLimit(drone.getWeightLimit());
        droneData.setBatteryCapacity(drone.getBatteryCapacity());
        /*List<MedicationData> medicationDataList = new ArrayList<>();
        for (Medication medication : drone.getMedicationList()){
            MedicationData medicationData = new MedicationData();
            medicationData.setId(medication.getId());
            medicationData.setCode(medication.getCode());
            medicationData.setName(medication.getName());
            medicationData.setWeight(medication.getWeight());
            medicationData.setImage(medication.getImage());
            medicationData.setIdSerialNumberDrone(drone.getSerialNumber());
            medicationDataList.add(medicationData);
        }
        droneData.setMedicationList(medicationDataList);*/
        return super.toEntity(saveData(droneData));
    }
}

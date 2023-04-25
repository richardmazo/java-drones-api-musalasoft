package co.com.musala.usecase;


import co.com.musala.model.drone.Drone;
import co.com.musala.model.drone.gateway.DroneRepository;
import co.com.musala.model.medication.Medication;
import co.com.musala.model.medication.gateway.MedicationRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MedicationUseCase {

    private final MedicationRepository medicationRepository;

    public List<Medication> getAllMedications(){
        return medicationRepository.findAllMedications();
    }

}

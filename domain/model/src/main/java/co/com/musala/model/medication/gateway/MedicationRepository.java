package co.com.musala.model.medication.gateway;

import co.com.musala.model.medication.Medication;

import java.util.List;

public interface MedicationRepository {
    List<Medication> findAllMedications();

    List<Medication> findByIdDrone(Long idDrone);
}

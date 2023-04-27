package co.com.musala.usecase;

import co.com.musala.model.drone.Drone;
import co.com.musala.model.drone.gateway.DroneRepository;
import co.com.musala.model.medication.Medication;
import co.com.musala.model.medication.gateway.MedicationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DroneUseCaseTest {


    private DroneUseCase droneUseCase;

    private MedicationUseCase medicationUseCase;
    private MedicationRepository medicationRepository;

    private DroneRepository droneRepository;

    private Drone drone;
    private Drone drone1;
    private Drone drone2;
    private Drone drone3;
    private Medication medication;
    private Medication medication1;
    private Medication medication2;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        drone = new Drone(1L,"ABC123","Lightweight",500.0,8.0,"LOADING",null);
        drone1 = new Drone(1L,"ABC123","Lightweight",600.0,8.0,"LOADING",null);
        medication = new Medication(1L, "Ibuprofen", 100.7, "MED_001", "https://example.com/ibuprofen.jpg", 1L);
        medication1 = new Medication(1L,"Ibuprofen", 100.7, "MED_001", "https://example.com/ibuprofen.jpg",1L);
        medication2 = new Medication(1L,"Ibuprofen", 550.0, "MED_001", "https://example.com/ibuprofen.jpg",1L);
        drone2 = new Drone(1L,"ABC123","Lightweight",500.0,8.0,"LOADING", Arrays.asList(medication, medication1));
        drone3 = new Drone(1L,"ABC123","Lightweight",500.0,8.0,"LOADING", Arrays.asList(medication2));
        medicationRepository = mock(MedicationRepository.class);
        medicationUseCase = spy(new MedicationUseCase(medicationRepository));
        droneRepository = mock(DroneRepository.class);
        droneUseCase = spy(new DroneUseCase(droneRepository,medicationUseCase));
    }

    @Test
    void getAllDrones() {
        when(droneRepository.getAllDronesWithMedications()).thenReturn(Collections.singletonList(drone));

    }

    @Test
    void saveDrone() {
        droneUseCase.saveDrone(drone);
        verify(droneUseCase,times(1)).saveDrone(any());
    }

    @Test
    void saveDroneFail() {
        assertThrows(IllegalArgumentException.class, () -> droneUseCase.saveDrone(drone1));
    }

    @Test
    void updateDroneWithMedications() {
        when(medicationUseCase.saveMedication(medication1)).thenReturn(medication1);
        when(medicationUseCase.saveMedication(medication)).thenReturn(medication);
        when(droneUseCase.saveDrone(drone2)).thenReturn(drone2);
        Drone drone = droneUseCase.updateDrone(drone2);
        assertEquals(201.4,drone.getMedicationList().get(0).getWeight()+drone.getMedicationList().get(1).getWeight());
    }
    @Test
    void updateDroneWithMedicationsMoreThan500() {
        assertThrows(IllegalArgumentException.class, () -> droneUseCase.updateDrone(drone3));
    }

    @Test
    void updateDroneWithMedicationsNull() {
        assertThrows(IllegalArgumentException.class, () -> droneUseCase.updateDrone(drone1));
    }

    @Test
    void findById() {
        when(droneUseCase.findById(1L)).thenReturn(drone);
        assertEquals("ABC123",droneUseCase.findById(1L).getSerialNumber());
    }

    @Test
    void checkBatteryLevel() {
    }

    @Test
    void findByAvailabilityDroneWithMedicationNull() {
        when(droneRepository.getAllDronesWithMedications()).thenReturn(Collections.singletonList(drone));
        List<Drone> droneList = droneUseCase.findByAvailability();
        assertEquals(500.0,droneList.get(0).getWeightLimit());
    }

    @Test
    void findByAvailability() {
        when(droneRepository.getAllDronesWithMedications()).thenReturn(Arrays.asList(drone2,drone3));
        List<Drone> droneList = droneUseCase.findByAvailability();
        assertEquals(1,droneList.size());
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}
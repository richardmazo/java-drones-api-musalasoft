package co.com.musala.jpa.drone;

import co.com.musala.jpa.medication.MedicationData;
import co.com.musala.model.drone.Drone;
import co.com.musala.model.medication.Medication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class DroneRepositoryAdapterTest {

    @Mock
    private DroneDataRepository droneDataRepository;

    @Mock
    private ObjectMapper objectMapper;

    private DroneRepositoryAdapter droneRepositoryAdapter;

    private AutoCloseable autoCloseable;
    private DroneData drone;
    private MedicationData medicationData;
    private Medication medication;
    private Drone drone1;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        droneRepositoryAdapter = spy(new DroneRepositoryAdapter(droneDataRepository,objectMapper));
        drone1 = new Drone(1L,"ABC123","Lightweight",500.0,8.0,"LOADING",null);
        drone = new DroneData();
        drone.setId(1L);
        drone.setModel("Lightweight");
        drone.setSerialNumber("ABC123");
        drone.setWeightLimit(500.0);
        drone.setBatteryCapacity(50.0);
        drone.setState("LOADING");
        drone.setMedicationList(null);
        medicationData = new MedicationData();
        medicationData.setCode("MED_001");
        medicationData.setId(1L);
        medicationData.setName("Ibuprofen");
        medicationData.setWeight(100.7);
        medicationData.setImage("https://example.com/ibuprofen.jpg");
        medicationData.setIdDrone(1L);
        medication = new Medication(1L,"Ibuprofen", 100.7, "MED_001", "https://example.com/ibuprofen.jpg",null);
    }

    @Test
    void findById() {
        when(droneDataRepository.findById(1L)).thenReturn(Optional.ofNullable(drone));
    }

    @Test
    void getAllDronesWithMedications() {
        when(objectMapper.map(any(), any())).thenReturn(drone);
        assertNotNull(droneRepositoryAdapter.getAllDronesWithMedications());
    }

    @Test
    void toDto() {
        assertEquals(medication.getId(), droneRepositoryAdapter.toDto(medicationData).getId());
    }

    @Test
    void saveDrone() {
        droneRepositoryAdapter.saveDrone(drone1);
        verify(droneRepositoryAdapter, times(1)).saveDrone(drone1);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}
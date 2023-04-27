package co.com.musala.usecase;

import co.com.musala.model.drone.Drone;
import co.com.musala.model.medication.Medication;
import co.com.musala.model.medication.gateway.MedicationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Collections;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

class MedicationUseCaseTest {

    private MedicationUseCase medicationUseCase;
    private MedicationRepository medicationRepository;
    private Medication medication;
    private Medication medication1;
    private Drone drone;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        drone = new Drone(1L,"ABC123","Lightweight",500.0,8.0,"LOADING",null);
        medication = new Medication(1L,"Ibuprofen", 100.7, "MED_001", "https://example.com/ibuprofen.jpg",null);
        medication1 = new Medication(1L,"Ibuprofen", 100.7, "MED_001", "https://example.com/ibuprofen.jpg",1L);
        medicationRepository = mock(MedicationRepository.class);
        medicationUseCase = spy(new MedicationUseCase(medicationRepository));
    }

    @Test
    void getAllMedications() {
        when(medicationRepository.findAllMedications()).thenReturn(Collections.singletonList(medication));
        assertEquals(1L,medication.getId());
    }

    @Test
    void getMedicationsByIdDrone() {
        when(medicationRepository.findByIdDrone(drone.getId())).thenReturn(Collections.singletonList(medication1));
        assertEquals(1L,medication1.getIdDrone());
    }

    @Test
    void saveMedication() {
        medicationUseCase.saveMedication(medication1);
        verify(medicationUseCase,times(1)).saveMedication(any());
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

}
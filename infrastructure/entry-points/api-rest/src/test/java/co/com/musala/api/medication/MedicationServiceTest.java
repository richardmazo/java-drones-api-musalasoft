package co.com.musala.api.medication;


import co.com.musala.model.medication.Medication;
import co.com.musala.usecase.MedicationUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MedicationServiceTest {

    @InjectMocks
    private MedicationService medicationService;
    @Mock
    private MedicationUseCase medicationUseCase;
    private AutoCloseable autoCloseable;
    private Medication medication;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        medication = new Medication(1L,"Ibuprofen", 100.7, "MED_001", "https://example.com/ibuprofen.jpg",null);
    }
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getMedications() {
        when(medicationUseCase.getAllMedications()).thenReturn(Collections.singletonList(medication));
        ResponseEntity<?> response = medicationService.getMedications();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getMedicationsByIdDrone() {
        when(medicationUseCase.getAllMedications()).thenReturn(Collections.singletonList(medication));
        ResponseEntity<?> response = medicationService.getMedications();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
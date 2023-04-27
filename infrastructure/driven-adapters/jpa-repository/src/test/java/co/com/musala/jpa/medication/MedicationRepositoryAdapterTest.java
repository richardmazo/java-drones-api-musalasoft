package co.com.musala.jpa.medication;

import co.com.musala.model.medication.Medication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.any;


class MedicationRepositoryAdapterTest {

    @Mock
    private MedicationDataRepository medicationDataRepository;

    @Mock
    private ObjectMapper objectMapper;

    private AutoCloseable autoCloseable;
    private MedicationRepositoryAdapter medicationRepositoryAdapter;
    private MedicationData medicationData;
    private Medication medication;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        medicationRepositoryAdapter = spy(new MedicationRepositoryAdapter(medicationDataRepository,objectMapper));
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
    void findAllMedications() {
        when(objectMapper.map(any(), any())).thenReturn(medication);
        assertNotNull(medicationRepositoryAdapter.findAllMedications());
    }

    @Test
    void findByIdDrone() {
        when(medicationDataRepository.findByIdDrone(1L)).thenReturn(Collections.singletonList(medicationData));
    }

    @Test
    void saveMedication() {
        medicationRepositoryAdapter.saveMedication(medication);
        verify(medicationRepositoryAdapter, times(1)).saveMedication(medication);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}
package co.com.musala.model.medication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MedicationTest {

    private Medication medication;

    @BeforeEach
    void setUp() {
        medication = new Medication(1L,"Ibuprofen", 100.7, "MED_001", "https://example.com/ibuprofen.jpg",null);
    }

    @Test
    void getId() {
        assertEquals(1L,medication.getId());
    }

    @Test
    void getName() {
        assertEquals("Ibuprofen",medication.getName());
    }

    @Test
    void getWeight() {
        assertEquals(100.7,medication.getWeight());
    }

    @Test
    void getCode() {
        assertEquals("MED_001",medication.getCode());
    }

    @Test
    void getImage() {
        assertNotEquals("image",medication.getImage());
    }

    @Test
    void getIdDrone() {
        assertNull(medication.getIdDrone());
    }

    @Test
    void builder() {
        Medication medication = Medication.builder().id(2L).build();
        assertEquals(2L, medication.getId());
    }
}
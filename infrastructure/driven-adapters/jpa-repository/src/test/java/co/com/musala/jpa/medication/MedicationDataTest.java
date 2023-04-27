package co.com.musala.jpa.medication;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MedicationDataTest {

    private MedicationData medicationData;
    @BeforeEach
    void setUp() {
        medicationData = new MedicationData();
        medicationData.setCode("MED_001");
        medicationData.setId(1L);
        medicationData.setName("Ibuprofen");
        medicationData.setWeight(100.7);
        medicationData.setImage("https://example.com/ibuprofen.jpg");
        medicationData.setIdDrone(1L);
    }

    @Test
    void getId() {
        assertEquals(1L, medicationData.getId());
    }

    @Test
    void getName() {
        assertNotEquals("MED_001",medicationData.getName());
    }

    @Test
    void getWeight() {
        assertNotNull(medicationData.getWeight());
    }

    @Test
    void getCode() {
        assertEquals("MED_001",medicationData.getCode());
    }

    @Test
    void getImage() {
        assertNotNull(medicationData.getImage());
    }

    @Test
    void getIdDrone() {
        assertNotEquals(2L,medicationData.getId());
    }

    @Test
    void getDroneData() {
        assertNull(medicationData.getDroneData());
    }
}
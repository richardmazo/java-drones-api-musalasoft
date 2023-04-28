package co.com.musala.jpa.drone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class DroneDataTest {

    private DroneData drone;
    @BeforeEach
    void setUp() {
        drone = new DroneData();
        drone.setId(1L);
        drone.setModel("Lightweight");
        drone.setSerialNumber("ABC123");
        drone.setWeightLimit(500.0);
        drone.setBatteryCapacity(50.0);
        drone.setState("LOADING");
        drone.setMedicationList(null);
    }

    @Test
    void getId() {
        assertEquals(1L, drone.getId());
    }

    @Test
    void getSerialNumber() {
        assertEquals("ABC123",drone.getSerialNumber());
    }

    @Test
    void getModel() {
        assertEquals("Lightweight",drone.getModel());
    }

    @Test
    void getWeightLimit() {
        assertEquals(500.0,drone.getWeightLimit());
    }

    @Test
    void getBatteryCapacity() {
        assertEquals(50.0,drone.getBatteryCapacity());
    }

    @Test
    void getState() {
        assertEquals("LOADING", drone.getState());
    }

    @Test
    void getMedicationList() {
        assertNull(drone.getMedicationList());
    }
}
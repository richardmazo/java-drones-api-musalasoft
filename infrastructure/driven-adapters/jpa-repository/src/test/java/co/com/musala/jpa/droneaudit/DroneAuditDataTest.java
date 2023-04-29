package co.com.musala.jpa.droneaudit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DroneAuditDataTest {

    private DroneAuditData drone;

    @BeforeEach
    void setUp() {
        drone = new DroneAuditData();
        drone.setId(1L);
        drone.setModel("Lightweight");
        drone.setSerialNumber("ABC123");
        drone.setWeightLimit(500.0);
        drone.setBatteryCapacity(50.0);
        drone.setState("LOADING");
        drone.setEventDate(null);
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
    void getEventDate() {
        assertNull(drone.getEventDate());
    }

}
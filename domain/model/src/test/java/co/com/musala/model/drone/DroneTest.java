package co.com.musala.model.drone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class DroneTest {

    private Drone drone;

    @BeforeEach
    void setUp() {
        drone = new Drone(1L,"ABC123","Lightweight",500.0,8.0,"LOADING",null);
    }

    @Test
    void getId() {
        assertEquals(1L,drone.getId());
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
        assertNotEquals(1.0,drone.getBatteryCapacity());
    }

    @Test
    void getState() {
        assertNotEquals("LOADED",drone.getState());
    }

    @Test
    void getMedicationList() {
        assertNull(drone.getMedicationList());
    }

    @Test
    void builder() {
        Drone drone = Drone.builder().model("Lightweight").build();
        assertEquals("Lightweight", drone.getModel());
    }

}
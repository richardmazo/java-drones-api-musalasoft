package co.com.musala.api.drone;

import co.com.musala.model.drone.Drone;
import co.com.musala.usecase.DroneUseCase;

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

class DroneServiceTest {

    @InjectMocks
    private DroneService droneService;
    @Mock
    private DroneUseCase droneUseCase;
    private AutoCloseable autoCloseable;
    private Drone drone;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        drone = new Drone(1L,"ABC123","Lightweight",500.0,8.0,"LOADING",null);
    }

    @Test
    void getDrones() {
        when(droneUseCase.getAllDrones()).thenReturn(Collections.singletonList(drone));
        ResponseEntity<?> response = droneService.getDrones();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void updateDroneWithMedications() {
        when(droneUseCase.updateDrone(drone)).thenReturn(drone);
        ResponseEntity<?> response = droneService.updateDroneWithMedications(1L,drone);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void saveDrone() {
        when(droneUseCase.saveDrone(drone)).thenReturn(drone);
        ResponseEntity<?> response = droneService.saveDrone(drone);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void checkDroneAvailable() {
        when(droneUseCase.findByAvailability()).thenReturn(Collections.singletonList(drone));
        ResponseEntity<?> response = droneService.checkDroneAvailable();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}
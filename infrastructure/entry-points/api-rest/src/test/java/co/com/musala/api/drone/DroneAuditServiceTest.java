package co.com.musala.api.drone;

import co.com.musala.model.drone.Drone;
import co.com.musala.usecase.DroneAuditUseCase;
import co.com.musala.usecase.DroneUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DroneAuditServiceTest {

    @InjectMocks
    private DroneAuditService droneAuditService;
    @Mock
    private DroneUseCase droneUseCase;

    @Mock
    private DroneAuditUseCase droneAuditUseCase;
    private AutoCloseable autoCloseable;
    private Drone drone;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        drone = new Drone(1L, "ABC123", "Lightweight", 500.0, 8.0, "LOADING", null);
    }

    @Test
    void verifyBatteryLevel() {
        when(droneUseCase.getAllDrones()).thenReturn(Collections.singletonList(drone));
        doNothing().when(droneAuditUseCase).registerDroneEvent(Collections.singletonList(drone));
        droneAuditService.verifyBatteryLevel();
        verify(droneAuditUseCase, times(1)).registerDroneEvent(Collections.singletonList(drone));
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}
package co.com.musala.usecase;

import co.com.musala.model.drone.Drone;
import co.com.musala.model.drone.gateway.DroneAuditRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;

class DroneAuditUseCaseTest {

    private DroneAuditUseCase droneAuditUseCase;
    private Drone drone;
    private Drone drone1;
    private DroneAuditRepository droneAuditRepository;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        drone = new Drone(1L,"ABC123","Lightweight",500.0,8.0,"LOADING",null);
        drone1 = new Drone(1L,"ABC123","Lightweight",600.0,8.0,"LOADING",null);
        droneAuditRepository = mock(DroneAuditRepository.class);
        droneAuditUseCase = spy(new DroneAuditUseCase(droneAuditRepository));
    }

    @Test
    public void registerDroneEvent(){
        droneAuditUseCase.registerDroneEvent(Arrays.asList(drone,drone1));
        verify(droneAuditUseCase,times(1)).registerDroneEvent(any());
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}
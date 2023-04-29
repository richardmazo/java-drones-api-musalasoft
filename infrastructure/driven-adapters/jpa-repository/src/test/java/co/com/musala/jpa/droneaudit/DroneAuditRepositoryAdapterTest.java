package co.com.musala.jpa.droneaudit;

import co.com.musala.model.drone.Drone;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

class DroneAuditRepositoryAdapterTest {

    @Mock
    private DroneAuditDataRepository droneAuditDataRepository;

    @Mock
    private ObjectMapper objectMapper;

    private DroneAuditRepositoryAdapter droneAuditRepositoryAdapter;

    private AutoCloseable autoCloseable;
    private Drone drone1;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        droneAuditRepositoryAdapter = spy(new DroneAuditRepositoryAdapter(droneAuditDataRepository,objectMapper));
        drone1 = new Drone(1L,"ABC123","Lightweight",500.0,8.0,"LOADING",null);
    }
    @Test
    void registerDroneEvent() {
        doNothing().when(droneAuditRepositoryAdapter).registerDroneEvent(Collections.singletonList(drone1));
        droneAuditRepositoryAdapter.registerDroneEvent(Collections.singletonList(drone1));
        verify(droneAuditRepositoryAdapter, times(1)).registerDroneEvent(Collections.singletonList(drone1));
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

}
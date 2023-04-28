package co.com.musala.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ObjectMapperConfigTest {

    ObjectMapperConfig objectMapperConfig;

    @BeforeEach
    void setUp() {
        objectMapperConfig = new ObjectMapperConfig();
    }

    @Test
    void objectMapper() {
        assertNotNull(objectMapperConfig.objectMapper());
    }
}
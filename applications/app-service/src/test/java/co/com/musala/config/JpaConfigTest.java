package co.com.musala.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JpaConfigTest {

    private JpaConfig jpaConfig;

    @BeforeEach
    void setUp() {
        jpaConfig = new JpaConfig();
    }

    @Test
    void getDataSource() {
        DriverManagerDataSource dataSource = (DriverManagerDataSource) jpaConfig.getDataSource();
        assertEquals("sa",dataSource.getUsername());

    }
}
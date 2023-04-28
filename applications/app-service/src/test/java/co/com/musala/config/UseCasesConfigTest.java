package co.com.musala.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UseCasesConfigTest {

    private UseCasesConfig useCasesConfig;

    @BeforeEach
    void setUp() {
        useCasesConfig = new UseCasesConfig();
    }

    @Test
    void test(){
        assertNotNull(useCasesConfig);
    }
}
package co.com.musala.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorMessageTest {

    private ErrorMessage errorMessage;

    @BeforeEach
    void setUp() {
        errorMessage = new ErrorMessage("Error test");
    }

    @Test
    void getMessage() {
        assertEquals("Error test",errorMessage.getMessage());
    }

    @Test
    void setMessage() {
        errorMessage.setMessage("Message error test");
        assertEquals("Message error test",errorMessage.getMessage());
    }
}
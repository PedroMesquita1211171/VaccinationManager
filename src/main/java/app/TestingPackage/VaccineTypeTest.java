package app.TestingPackage;

import app.domain.model.VaccineType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaccineTypeTest {

    @Test
    void testInvalidCode() {
       Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccineType vaccineType = new VaccineType("","VaccineTypeDesignation","Non-Relevant");
        });

       assertEquals("Code cannot be blank.", thrown.getMessage());
    }

    @Test
    void testInvalidCode2(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccineType vaccineType = new VaccineType("123456789","VaccineTypeDesignation","Non-Relevant");
        });

        assertEquals("Code must have 4 to 8 chars.", thrown.getMessage());
    }

    @Test
    void testInvalidCode3(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccineType vaccineType = new VaccineType("123","VaccineTypeDesignation","Non-Relevant");
        });

        assertEquals("Code must have 4 to 8 chars.", thrown.getMessage());
    }

    @Test
    void testInvalidDesignation() {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccineType vaccineType = new VaccineType("12345","","Non-Relevant");
        });

        assertEquals("Designation cannot be blank.", thrown.getMessage());
    }

    @Test
    void testInvalidDesignation2(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccineType vaccineType = new VaccineType("12345","12345678901234567890123456789012345678901","Non-Relevant");
        });

        assertEquals("Designation must have less than 40 chars.", thrown.getMessage());
    }

}
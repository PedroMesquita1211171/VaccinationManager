package app.TestingPackage;
import app.domain.model.ScheduleVaccine;
import app.domain.shared.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScheduleVaccineTest {
    @Test
    void testInvalidDate(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            ScheduleVaccine scdh = new ScheduleVaccine(null, Constants.hour,"111333111","Rua 1","Boda");
        });
        assertEquals("Date can't be null or empty!", thrown.getMessage());
    }
    @Test
    void testInvalidHour(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            ScheduleVaccine scdh = new ScheduleVaccine(Constants.date, null,"111333111","Rua 1","Boda");
        });
        assertEquals("Hour can't be null or empty!", thrown.getMessage());
    }
    @Test
    void testInvalidNumber(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            ScheduleVaccine scdh = new ScheduleVaccine(Constants.date, Constants.hour,"","Rua 1","Boda");
        });
        assertEquals("Sns number can't be null or empty!", thrown.getMessage());
    }
    @Test
    void testInvalidAddress(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            ScheduleVaccine scdh = new ScheduleVaccine(Constants.date, Constants.hour,"111333111","","Boda");
        });
        assertEquals("Address can't be null or empty!", thrown.getMessage());
    }
    @Test
    void testInvalidVaccine(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            ScheduleVaccine scdh = new ScheduleVaccine(Constants.date, Constants.hour,"111333111","Rua 1","");
        });
        assertEquals("Vaccine can't be null or empty!", thrown.getMessage());
    }
}

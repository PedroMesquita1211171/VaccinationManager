package app.TestingPackage;

import app.domain.model.VaccinationCenter;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class VaccineCenterTest {
    @Test
    void testInvalidAddress() {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("R", "example@gmail.com", "999999999", "111111111", "http://www.example.com/index.html", "08:00", "23:00", 20, 10, "João");
        });
        assertEquals("Address can´t have less than 3 characters!", thrown.getMessage());
    }
    @Test
    void testInvalidAddress2() {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "example@gmail.com", "999999999", "111111111", "http://www.example.com/index.html", "08:00", "23:00", 20, 10, "João");
        });
        assertEquals("Address can't have more than 50 characters!", thrown.getMessage());
    }
    @Test
    void testInvalidAddress3() {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("", "example@gmail.com", "999999999", "111111111", "http://www.example.com/index.html", "08:00", "23:00", 20, 10, "João");
        });
        assertEquals("Address can't be null or empty!", thrown.getMessage());
    }

    @Test
    void testInvalidEmailAddress(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","examplegmailcom","999999999","111111111","http://www.example.com/index.html","08:00","23:00",20,10,"João");
        });
        assertEquals("Email Is Not Valid!", thrown.getMessage());
    }
    @Test
    void testInvalidEmailAddress2(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","","999999999","111111111","http://www.example.com/index.html","08:00","23:00",20,10,"João");
        });
        assertEquals("Email address can't be null or empty!", thrown.getMessage());
    }
    @Test
    void testInvalidPhoneNumber(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","","111111111","http://www.example.com/index.html","08:00","23:00",20,10,"João");
        });
        assertEquals("Phone number can't be null or empty!", thrown.getMessage());
    }
    @Test
    void testInvalidPhoneNumber2(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","99999999","111111111","http://www.example.com/index.html","08:00","23:00",20,10,"João");
        });
        assertEquals("Phone number has to have 9 numbers!", thrown.getMessage());
    }
    @Test
    void testInvalidFaxNumber(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","","http://www.example.com/index.html","08:00","23:00",20,10,"João");
        });
        assertEquals("Fax number can't be null or empty!", thrown.getMessage());
    }
    @Test
    void testInvalidFaxNumber2(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","11111111","http://www.example.com/index.html","08:00","23:00",20,10,"João");
        });
        assertEquals("Fax number has to have 9 numbers!", thrown.getMessage());
    }
    @Test
    void testInvalidWebsite(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","","08:00","23:00",20,10,"João");
        });
        assertEquals("Website address can't be null or empty!", thrown.getMessage());
    }
    @Test
    void testInvalidWebsite2(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","httpwwwexamplecomindexhtml","08:00","23:00",20,10,"João");
        });
        assertEquals("Website address is invalid!", thrown.getMessage());
    }
    @Test
    void testInvalidOpeningHours(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","http://www.example.com/index.html","","23:00",20,10,"João");
        });
        assertEquals("Opening Hours can't be null or empty", thrown.getMessage());
    }
    @Test
    void testInvalidOpeningHours2(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","http://www.example.com/index.html","0800","23:00",20,10,"João");
        });
        assertEquals("Invalid format for opening hours! Try XX:XX.", thrown.getMessage());
    }
    @Test
    void testInvalidClosingHours(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","http://www.example.com/index.html","08:00","",20,10,"João");
        });
        assertEquals("Closing hours can't be null or empty", thrown.getMessage());
    }
    @Test
    void testInvalidClosingHours2(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","http://www.example.com/index.html","08:00","2300",20,10,"João");
        });
        assertEquals("Invalid format for closing hours! Try XX:XX.", thrown.getMessage());
    }
    @Test
    void testInvalidSlotDuration(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","http://www.example.com/index.html","08:00","23:00",0,10,"João");
        });
        assertEquals("Slot duration cant be 0!", thrown.getMessage());
    }
    @Test
    void testInvalidSlotDuration2(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","http://www.example.com/index.html","08:00","23:00",-1,10,"João");
        });
        assertEquals("Slot duration cant be negative!", thrown.getMessage());
    }
    @Test
    void testInvalidMaxVaccines(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","http://www.example.com/index.html","08:00","23:00",20,0,"João");
        });
        assertEquals("Max vaccines cant be 0!", thrown.getMessage());
    }
    @Test
    void testInvalidMaxVaccines2(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","http://www.example.com/index.html","08:00","23:00",20,-1,"João");
        });
        assertEquals("Max vaccines cant be negative!", thrown.getMessage());
    }
    @Test
    void testInvalidCoordinator(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","http://www.example.com/index.html","08:00","23:00",20,10,"");
        });
        assertEquals("Coordinator can't be null or empty", thrown.getMessage());
    }
    @Test
    void testInvalidAges(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","http://www.example.com/index.html","08:00","23:00",20,10,"João","","ARS");
        });
        assertEquals("AGES can't be null or empty", thrown.getMessage());
    }
    @Test
    void testInvalidArs(){
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            VaccinationCenter vacc = new VaccinationCenter("Rua 3","example@gmail.com","999999999","111111111","http://www.example.com/index.html","08:00","23:00",20,10,"João","Norte","");
        });
        assertEquals("ARS can't be null or empty", thrown.getMessage());
    }
}
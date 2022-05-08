package app.TestingPackage;

import app.domain.model.Vaccine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaccineTest {

    @Test
    void nameNotValid1(){
        //Invalid name testing
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Vaccine vac = new Vaccine("",1,"Testing",1,1,1,1);
        });
        assertEquals("Name can't be empty or null!", thrown.getMessage());
    }


    @Test
    void nameNotValid2(){
        //Invalid name testing
        Throwable thrown11 = assertThrows(IllegalArgumentException.class, () -> {
            Vaccine vac = new Vaccine("AAAAAAAAAAAAAAAAAAAAAA",1,"Testing",1,1,1,1);
        });
        assertEquals("Name Can't Have More Than 20 Characters", thrown11.getMessage());
    }

    @Test
    void nameNotValid3() {
        //Invalid name testing
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Vaccine vac = new Vaccine("hi",1,"Testing",1,1,1,1);
        });
        assertEquals("Name is too short!", thrown.getMessage());
    }

    @Test
    void IDNotValid() {
        //Invalid ID testing
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Vaccine vac = new Vaccine("Testing",0,"Testing",1,1,1,1);
        });
        assertEquals("ID must be greater than 0", thrown.getMessage());
    }



    @Test
    void brandNotValid(){
        //Invalid brand testing
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Vaccine vac = new Vaccine("Testing",1,"",1,1,1,1);
        });
        assertEquals("Brand can't be empty or null!", thrown.getMessage());
    }

    @Test
    void brandNotValid2(){
        //Invalid brand testing
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Vaccine vac = new Vaccine("Testing",1,"AAAAAAAAAAAAAAAAAAAAAA",1,1,1,1);
        });
        assertEquals("Brand Can't Have More Than 20 Characters", thrown.getMessage());
    }

    @Test
    void brandNotValid3() {
        //Invalid brand testing
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Vaccine vac = new Vaccine("Testing",1,"hi",1,1,1,1);
        });
        assertEquals("Brand is too short!", thrown.getMessage());
    }

    @Test
    void dosesNotValid() {
        //Invalid doses testing
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Vaccine vac = new Vaccine("Testing", 1, "Testing", 0, 1, 1, 1);
        });
        assertEquals("Number of doses must be greater than 0", thrown.getMessage());
    }

    @Test
    void dosageNotValid() {
        //Invalid dosage testing
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Vaccine vac = new Vaccine("Testing", 1, "Testing", 1, 0, 1, 1);
        });
        assertEquals("Dosage must be greater than 0ml", thrown.getMessage());
    }

    @Test
    void recoveryNotValid() {
        //Invalid recovery testing
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Vaccine vac = new Vaccine("Testing", 1, "Testing", 1, 1, 0, 1);
        });
        assertEquals("Recovery days must be greater than 0", thrown.getMessage());
    }

    @Test
    void doseintervalNotValid() {
        //Invalid doseinterval testing
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Vaccine vac = new Vaccine("Testing", 1, "Testing", 1, 1, 1, 0);
        });
        assertEquals("Dose interval days must be greater than 0", thrown.getMessage());
    }
}
package app.TestingPackage;

import app.domain.model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @Test
    void testInvalidName() {
        //Invalid name testing
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            Employee emp = new Employee("A", "example@gmail.com", "Rua x", "912345678", "10102020", "Nurse");
        });
        assertEquals("Name is too short!", thrown.getMessage());
    }
    @Test
    void testInvalidName3() {
        //Invalid name testing
        Throwable thrown11 = assertThrows(IllegalArgumentException.class, () -> {
            Employee emp = new Employee("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "example@gmail.com", "Rua x", "912345678", "10102020", "Nurse");
        });
        assertEquals("Name Can't Have More Than 20 Characters", thrown11.getMessage());
    }
    @Test
    void testInvalidEmail() {
        //Invalid email testing
        Throwable thrown2 = assertThrows(IllegalArgumentException.class, () -> {
            Employee emp = new Employee("Test", "examplegmailcom", "Rua x", "912345678", "10102020", "Nurse");
        });
        assertEquals("Email Is Not Valid!", thrown2.getMessage());
    }

    @Test
    void testInvalidEmail2() {
        //Invalid email testing
        Throwable thrown22 = assertThrows(IllegalArgumentException.class, () -> {
            Employee emp = new Employee("Test", "", "Rua x", "912345678", "10102020", "Nurse");
        });
        assertEquals("Email Can't Be Null Or Empty!", thrown22.getMessage());
    }
    @Test
    void testInvalidAddress() {
        //Invalid Address testing
        Throwable thrown3 = assertThrows(IllegalArgumentException.class, () -> {
            Employee emp = new Employee("Test", "example@gmail.com", "R", "912345678", "10102020", "Nurse");
        });
        assertEquals("Address is too short!", thrown3.getMessage());
    }
    @Test
    void testInvalidAddress2() {
        //Invalid Citizen Card Number testing
        Throwable thrown33 = assertThrows(IllegalArgumentException.class, () -> {
            Employee emp = new Employee("Test", "example@gmail.com", "Rua xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", "912345678", "10102020", "Nurse");
        });
        assertEquals("Address is too long!", thrown33.getMessage());
    }
    @Test
    void testInvalidPhonenumber() {
        //Invalid Citizen Card Number testing
        Throwable thrown4 = assertThrows(IllegalArgumentException.class, () -> {
            Employee emp = new Employee("Test", "example@gmail.com", "Rua x", "9123456789", "10102020", "Nurse");
        });
        assertEquals("Invalid Phone Number", thrown4.getMessage());
    }
    @Test
    void testInvalidCitizenCardNumber() {
        //Invalid Citizen Card Number testing
        Throwable thrown5 = assertThrows(IllegalArgumentException.class, () -> {
            Employee emp = new Employee("Test", "example@gmail.com", "Rua x", "912345678", "1010", "Nurse");
        });
        assertEquals("Invalid Citizen Card Number", thrown5.getMessage());
    }

}

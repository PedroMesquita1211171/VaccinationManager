package app.TestingPackage;

import app.domain.model.SNSUser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SNSUserTest {

    @Test
    void testInvalidName() {
        //Invalid name testing
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            SNSUser user = new SNSUser("", "Rua x", "1", "912345678", "example@gmail.com", "1-1-2000", "123456789", "10102020");
        });
        assertEquals("Name is too short", thrown.getMessage());
    }

    @Test
    void testInvalidAddress() {
        //Invalid address testing
        Throwable thrown2 = assertThrows(IllegalArgumentException.class, () -> {
            SNSUser user = new SNSUser("Example", "", "1", "912345678", "example@gmail.com", "1-1-2000", "123456789", "10102020");
        });
        assertEquals("Address is too short", thrown2.getMessage());
    }

    @Test
    void testInvalidPhoneNumber() {
        //Invalid phone number testing
        Throwable thrown3 = assertThrows(IllegalArgumentException.class, () -> {
            SNSUser user = new SNSUser("Example", "Rua x", "1", "9123456789", "example@gmail.com", "1-1-2000", "123456789", "10102020");
        });
        assertEquals("Invalid Phone Number", thrown3.getMessage());
    }

    @Test
    void testInvalidEmail() {
        //Invalid email testing
        Throwable thrown4 = assertThrows(IllegalArgumentException.class, () -> {
            SNSUser user = new SNSUser("Example", "Rua x", "1", "912345678", "examplegmailcom", "1-1-2000", "123456789", "10102020");
        });
        assertEquals("Email Is Not Valid!", thrown4.getMessage());
    }

    @Test
    void testInvalidEmail2() {
        //Invalid email testing
        Throwable thrown44 = assertThrows(IllegalArgumentException.class, () -> {
            SNSUser user = new SNSUser("Example", "Rua x", "1", "912345678", "", "1-1-2000", "123456789", "10102020");
        });
        assertEquals("Email Can't Be Null Or Empty!", thrown44.getMessage());

    }

    @Test
    void testInvalidSNSNumber() {
        //Invalid SNS Number testing
        Throwable thrown5 = assertThrows(IllegalArgumentException.class, () -> {
            SNSUser user = new SNSUser("Example", "Rua x", "1", "912345678", "example@gmail.com", "1-1-2000", "12345678", "10102020");
        });
        assertEquals("Invalid SNS Number", thrown5.getMessage());
    }

    @Test
    void testInvalidCitizenCardNumber() {
        //Invalid Citizen Card Number testing
        Throwable thrown6 = assertThrows(IllegalArgumentException.class, () -> {
            SNSUser user = new SNSUser("Example", "Rua x", "1", "912345678", "example@gmail.com", "1-1-2000", "123456789", "1010202");
        });
        assertEquals("Invalid Citizen Card Number", thrown6.getMessage());
    }

}
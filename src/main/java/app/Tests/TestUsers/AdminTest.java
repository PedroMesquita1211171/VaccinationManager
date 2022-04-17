package app.Tests.TestUsers;

import app.Users.Admin;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminTest {

    @Test
    public void AdminTestFunctional() {
        Admin admin = new Admin("admin", "admin");
        assertEquals(admin.showUsername(), "admin");
        assertEquals(admin.showPassword(), "admin");
        assertEquals(admin, new Admin(admin.showUsername(), admin.showPassword()));
    }

    @Test(expected = NullPointerException.class)
    public void AdminTestAllNull() {
        new Admin(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void AdminTestUsernameNull() {
        new Admin(null, "admin");
    }

    @Test(expected = NullPointerException.class)
    public void AdminTestPasswordNull() {
        new Admin("admin", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AdminTestUsernameEmpty() {
        new Admin("", "admin");
    }

    @Test(expected = IllegalArgumentException.class)
    public void AdminTestPasswordEmpty() {
        new Admin("admin", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void AdminTestAllEmpty() {
        new Admin("", "");
    }
}
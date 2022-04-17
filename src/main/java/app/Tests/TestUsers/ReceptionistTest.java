package app.Tests.TestUsers;

import app.Users.Receptionist;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceptionistTest {
    @Test
    public void ReceptionistTestFunctional(){
        Receptionist receptionist = new Receptionist("Receptionist", "receptionist");
        assertEquals("Receptionist", receptionist.showUsername());
        assertEquals("receptionist", receptionist.showPassword());
        assertEquals(receptionist,new Receptionist("Receptionist", "receptionist"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ReceptionistTestAllEmpty(){
        Receptionist receptionist = new Receptionist("","");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ReceptionistTestUsernameEmpty(){
        Receptionist receptionist = new Receptionist("","receptionist");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ReceptionistTestPasswordEmpty(){
        Receptionist receptionist = new Receptionist("Receptionist","");
    }

    @Test(expected = NullPointerException.class)
    public void ReceptionistTestUsernameNull(){
        Receptionist receptionist = new Receptionist(null,"receptionist");
    }

    @Test(expected = NullPointerException.class)
    public void ReceptionistTestPasswordNull(){
        Receptionist receptionist = new Receptionist("Receptionist",null);
    }

    @Test(expected = NullPointerException.class)
    public void ReceptionistTestAllNull(){
        Receptionist receptionist = new Receptionist(null,null);
    }


}
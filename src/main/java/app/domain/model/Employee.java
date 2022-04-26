package app.domain.model;

import app.domain.shared.Constants;
import org.junit.platform.commons.util.StringUtils;

public class Employee {

    private String Role;
    private String Name;
    private String Ccardnumber;
    private String Phonenumber;
    private String Adress;
    private String Email;

    public Employee (String Role,String Name, String Ccardnumber, String Phonenumber, String Adress, String Email) {

        this.Role= Role;
        this.Name = Name;
        this.Ccardnumber = Ccardnumber;
        this.Phonenumber = Phonenumber;
        this.Adress= Adress;
        this.Email= Email;
    }
}

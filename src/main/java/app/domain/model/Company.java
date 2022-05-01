package app.domain.model;

import app.domain.Store.EmployeeStore;
import app.domain.Store.SNSUserStore;
import app.domain.Store.VaccineTypeStore;
import app.domain.shared.Constants;
import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;
import java.security.SecureRandom;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;
    private VaccineTypeStore vaccineTypeStore;
    private EmployeeStore employeeStore;
    private SNSUserStore snsUserStore;

    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.vaccineTypeStore = new VaccineTypeStore();
        this.employeeStore = new EmployeeStore();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public void  addVaccineType(VaccineType vt) {
        vaccineTypeStore.addVaccineType(vt);
    }

    public VaccineTypeStore getVaccineTypeStore() {
        return vaccineTypeStore;
    }

    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    public void addEmployee (Employee e) {
        employeeStore.addEmployee(e);
        authFacade.addUserWithRole(e.getName(), e.getEmail(),generateRandomPassword(), e.getRole() );
    }

    public SNSUserStore getSNSUserStore() {
        return snsUserStore;
    }

    public void addSNSUser (SNSUser snsu) {
        snsUserStore.addSNSUser(snsu);
        authFacade.addUserWithRole(snsu.getName(), snsu.getEmail(),generateRandomPassword(), Constants.ROLE_SNSUSER);

    }

    public static String generateRandomPassword()
    {
        int len = (int) ((Math.random() * (20 - 8)) + 8);
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        //special characters: !@#$%^&*
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

}



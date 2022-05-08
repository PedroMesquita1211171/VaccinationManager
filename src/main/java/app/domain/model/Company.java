package app.domain.model;

import app.domain.Store.EmployeeStore;
import app.domain.Store.SNSUserStore;
import app.domain.Store.VaccinationCenterStore;
import app.domain.Store.VaccineTypeStore;
import app.domain.shared.Constants;
import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    FileWriter writer;

    private String designation;
    private AuthFacade authFacade;
    private VaccineTypeStore vaccineTypeStore;
    private EmployeeStore employeeStore;
    private SNSUserStore snsUserStore;
    private VaccinationCenterStore vaccinationCenterStore ;

    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.vaccineTypeStore = new VaccineTypeStore();
        this.employeeStore = new EmployeeStore();
        this.snsUserStore = new SNSUserStore();
        this.vaccinationCenterStore = new VaccinationCenterStore();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public VaccineTypeStore getVaccineTypeStore() {
        return vaccineTypeStore;
    }

    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    public SNSUserStore getSNSUserStore() {
        return snsUserStore;
    }

    public VaccinationCenterStore getVaccinationCenterStore() { return vaccinationCenterStore; }

    /**
     * Adds a new employee
     * @param e
     */
    public void addEmployee(Employee e) {
        String employeeID=generateEmployeeID();
        String password = generateRandomPassword();
        employeeStore.addEmployee(e);
        authFacade.addUserWithRole(e.getName(), e.getEmail(),password, e.getRole());

        writeEmployeeToFile(e, password, employeeID);

    }

    public void addSNSUser (SNSUser snsu) {
        String password = generateRandomPassword();
        snsUserStore.addSNSUser(snsu);
        authFacade.addUserWithRole(snsu.getName(), snsu.getEmail(),password, Constants.ROLE_SNSUSER);

        writeSNSUserToFile(snsu,password);

    }

    public void  addVaccineType(VaccineType vt) { vaccineTypeStore.addVaccineType(vt); }

    public void addVaccinationCenter(VaccinationCenter vac) { vaccinationCenterStore.addVaccinationCenter(vac); }

    /**
     * Writes Employees useful info for login into a text file
     * @param e
     * @param password
     * @param employeeID
     */

    public void writeEmployeeToFile(Employee e, String password, String employeeID){
        try {
            writer = new FileWriter("Employees.txt", true);
            writer.write("\n\n" + "Employee" +"\n" + "Email: " + e.getEmail() + "\n" + "Name: " + e.getName() + "\n" + "EmployeeID "+ employeeID+ "\n" + "Password: " + password + "\n" + "Role: " + e.getRole() + "\n");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error while creating file\nEmployee not added");
            authFacade.removeUser(e.getEmail());
        }

    }

    /**
     * Writes SNS User useful info for login into a text file
     * @param snsu
     * @param password
     */

    public void writeSNSUserToFile(SNSUser snsu, String password){
        try {
            writer = new FileWriter("SNSUsers.txt", true);
            writer.write("\n\n" + "SNS User" + "\n" + "Email: " + snsu.getEmail() + "\n" + "Name: " + snsu.getName() + "\n" + "Password: " + password + "\n");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error while creating file\nSNS User not added");
            authFacade.removeUser(snsu.getEmail());
        }

    }

    /**
     * Generates a random password
     * @return sb.toString
     */
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
    public static String generateEmployeeID()
    {
        int len = 8;
        final String chars = "0123456789";

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



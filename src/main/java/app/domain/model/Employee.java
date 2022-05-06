package app.domain.model;

import app.domain.shared.Constants;
import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

public class Employee {

    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String citizenCardNumber;
    private int employeeID;
    private String role;

    /**
     * Instanciates a new Employee object
     *
     * @param name              employee's name
     * @param email             employee's email
     * @param address           employee's address
     * @param phoneNumber       employee's phone number
     * @param citizenCardNumber employee's citizen card number
     * @param employeeID        employee's ID
     * @param role              employee's role
     */

    public Employee(String name, String email, String address, String phoneNumber, String citizenCardNumber, int employeeID, String role) {
        checkName(name);
        checkEmail(email);
        checkAddress(address);
        checkPhoneNumber(phoneNumber);
        checkCitizenCardNumber(citizenCardNumber);

        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.citizenCardNumber = citizenCardNumber;
        this.employeeID = employeeID;
        this.role = role;
    }

    /**
     * Checks if Employee parameters are valid.
     */

    private void checkName(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name Can't Be Null!");

        if (name.isEmpty())
            throw new IllegalArgumentException("Name Can't Be Empty!");

        if (name.length() > 20)
            throw new IllegalArgumentException("Name Can't Have More Than 20 Characters");
    }

    private void checkEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email Can't Be Null Or Empty!");
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(email).matches()) {
             throw new IllegalArgumentException("Email Is Not Valid!");
        }
    }

    private void checkAddress(String address) {
        if (address == null)
            throw new IllegalArgumentException("Address Can't Be Null!");

        if (address.isEmpty())
            throw new IllegalArgumentException("Address Can't Be Empty!");

        if (address.length() > 50)
            throw new IllegalArgumentException("Address Can't Have More Than 50 Characters");
    }

    private void checkPhoneNumber2(String phoneNumber) {
        if (phoneNumber == null) throw new IllegalArgumentException("Phone Number Can't Be Null!");
        String phoneNumberRegex = "^[0-9]{9}$";

        Pattern pattern = Pattern.compile(phoneNumberRegex);

        if (!pattern.matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Phone Number Is Not Valid!");
        }
    }

    private void checkPhoneNumber(String phoneNumber){
        if(phoneNumber.length() != 9 || phoneNumber.charAt(0) != '9'){
            throw new IllegalArgumentException("Invalid Phone Number");
        }
    }

    private void checkCitizenCardNumber(String citizenCardNumber) {
        String citizenCardNumberRegex = "^[0-9]{8}$";

        Pattern pattern = Pattern.compile(citizenCardNumberRegex);

        if (!pattern.matcher(citizenCardNumber).matches()) {
            throw new IllegalArgumentException("Invalid Citizen Card Number");
        }
    }

    /**
     *Returns the Employee object as a String
     * @return employee as a String
     */

    @Override
    public String toString() {
        return "\n\nName: " + name + "\n" +
                "Email: " + email + "\n" +
                "Address: " + address + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Citizen Card Number: " + citizenCardNumber + "\n" +
                "EmployeeID: " + employeeID + "\n" +
                "Role: " + role + "\n\n";
    }

    /**
     * Gets employee name.
     *
     * @return the name
     */

    public String getName() {
        return name;
    }

    /**
     * Gets employee email.
     *
     * @return the email
     */

    public String getEmail() {
        return email;
    }

    /**
     * Gets employee address.
     *
     * @return the address
     */

    public String getAddress() {
        return address;
    }

    /**
     * Gets employee phone number.
     *
     * @return the phone number
     */

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets employee citizen card number.
     *
     * @return the citizen card number
     */

    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    /**
     * Gets employee ID.
     *
     * @return the employee ID
     */

    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Gets employee role.
     *
     * @return the role
     */

    public String getRole() {
        return role;
    }
}

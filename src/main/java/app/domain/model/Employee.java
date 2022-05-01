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

    private void checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) throw new IllegalArgumentException("Phone Number Can't Be Null!");
        String phoneNumberRegex = "^[0-9]{9}$";

        Pattern pattern = Pattern.compile(phoneNumberRegex);

        if (!pattern.matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Phone Number Is Not Valid!");
        }
    }

    private void checkCitizenCardNumber(String citizenCardNumber) {
        String citizenCardNumberRegex = "^[0-9]{8}$";

        Pattern pattern = Pattern.compile(citizenCardNumberRegex);

        if (!pattern.matcher(citizenCardNumber).matches()) {
            throw new IllegalArgumentException("Invalid Citizen Card Number");
        }
    }

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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getRole() {
        return role;
    }
}

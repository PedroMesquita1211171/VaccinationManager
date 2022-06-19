package app.DTO;

import java.io.Serializable;

/**
 * The type Employee dto.
 */
public class EmployeeDTO implements Serializable {

    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String citizenCardNumber;
    private String role;
    private String empID;

    /**
     * Instantiates a new Employee dto.
     *
     * @param name              the name
     * @param email             the email
     * @param address           the address
     * @param phoneNumber       the phone number
     * @param citizenCardNumber the citizen card number
     * @param role              the role
     * @param empID             the emp id
     */
    public EmployeeDTO(String name, String email, String address, String phoneNumber, String citizenCardNumber, String role, String empID) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.citizenCardNumber = citizenCardNumber;
        this.role = role;
        this.empID = empID;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets citizen card number.
     *
     * @return the citizen card number
     */
    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Gets emp id.
     *
     * @return the emp id
     */
    public String getEmpID() {
        return empID;
    }

    /**
     * gets EmployeeDTO as a string
     *
     * @return the Employee dto in a string format
     */
    @Override
    public String toString() {
        return
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Address: " + address + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Citizen Card Number: " + citizenCardNumber + "\n" +
                "Role: " + role + "\n"
                ;
    }
}

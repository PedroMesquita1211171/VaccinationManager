package app.domain.model;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * The type Employee.
 */
public class Employee {

    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String citizenCardNumber;
    private String role;
    private String empID;

    /**
     * Instanciates a new Employee object
     *
     * @param name              employee's name
     * @param email             employee's email
     * @param address           employee's address
     * @param phoneNumber       employee's phone number
     * @param citizenCardNumber employee's citizen card number
     * @param role              employee's role
     * @param empID             the emp id
     */
    public Employee(String name, String email, String address, String phoneNumber, String citizenCardNumber, String role, String empID) {
        checkName(name);
        checkEmail(email);
        checkAddress(address);
        checkPhoneNumber(phoneNumber);
        checkCitizenCardNumber(citizenCardNumber);
        checkEmployeeID(empID);

        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.citizenCardNumber = citizenCardNumber;
        this.role = role;
        this.empID = empID;
    }


    /**
     * Checks if the employee Name is valid
     * @param name
     */
    private void checkName(String name) {
        if (name.length() < 3)
            throw new IllegalArgumentException("Name is too short!");

        if (name.length() > 100)
            throw new IllegalArgumentException("Name Can't Have More Than 100 Characters");
    }
  /**
   * Checks if the employee email is valid
   * @param email
   */
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
    /**
     * Checks if the employee address is valid
     * @param address
     */
    private void checkAddress(String address) {
        if (address.length() < 3)
            throw new IllegalArgumentException("Address is too short!");

        if (address.length() > 200)
            throw new IllegalArgumentException("Address is too long!");
    }
      /**
     * Checks if the employee phone number is valid
     * @param phoneNumber
     */
    private void checkPhoneNumber(String phoneNumber){
        if(phoneNumber.length() != 9 || phoneNumber.charAt(0) != '9'){
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        try{
            Long.parseLong(phoneNumber);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid Phone Number");
        }
    }
    /**
     * Checks if the employee citizen card number is valid
     * @param citizenCardNumber
     */
    private void checkCitizenCardNumber(String citizenCardNumber) {
        String citizenCardNumberRegex = "^[0-9]{8}$";

        Pattern pattern = Pattern.compile(citizenCardNumberRegex);

        if (!pattern.matcher(citizenCardNumber).matches()) {
            throw new IllegalArgumentException("Invalid Citizen Card Number");
        }
    }
    /**
     * Checks if the employee ID is valid
     * @param empID
     */
    private void checkEmployeeID(String employeeID){
        if(employeeID.length() != 8){
            throw new IllegalArgumentException("Invalid EmployeeID");
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
     * Gets employee role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Gets employee ID.
     *
     * @return the id
     */
    public String getId() {
        return empID;
    }

    /**
     * Sets employee name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets employee email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets employee address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets employee phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets employee citizen card number.
     *
     * @param citizenCardNumber the citizen card number
     */
    public void setCitizenCardNumber(String citizenCardNumber) {
        this.citizenCardNumber = citizenCardNumber;
    }

    /**
     * Sets employee role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Sets employee ID.
     *
     * @param empID the id
     */
    public void setId(String empID) {
        this.empID = empID;
    }

    /**
     * Equals method.
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(email, employee.email) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(citizenCardNumber, employee.citizenCardNumber) && Objects.equals(empID, employee.empID);
    }
}

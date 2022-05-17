package app.DTO;

public class EmployeeDTO {

    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String citizenCardNumber;
    private String role;

    public EmployeeDTO(String name, String email, String address, String phoneNumber, String citizenCardNumber, String role) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.citizenCardNumber = citizenCardNumber;
        this.role = role;
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

    public String getRole() {
        return role;
    }

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

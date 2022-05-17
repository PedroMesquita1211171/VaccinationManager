package app.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SNSUserDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private Date birthDate;
    private String SNSNumber;
    private String citizenCardNumber;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public SNSUserDTO(String name, String address, String phoneNumber, String email, Date birthDate, String SNSNumber, String citizenCardNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
        this.SNSNumber = SNSNumber;
        this.citizenCardNumber = citizenCardNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getSNSNumber() {
        return SNSNumber;
    }

    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    @Override
    public String toString() {
        return
                "\n\nName: " + name + "\n" +
                "Address: " + address + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email: " + email + "\n" +
                "Birth Date: " + sdf.format(birthDate) + "\n" +
                "SNS Number: " + SNSNumber + "\n" +
                "Citizen Card Number: " + citizenCardNumber + "\n\n"  ;
    }
}

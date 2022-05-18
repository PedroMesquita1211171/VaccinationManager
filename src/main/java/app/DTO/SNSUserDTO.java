package app.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Sns user dto.
 *
 * @author Henrique Pinto - 1211201
 */
public class SNSUserDTO {
    private String name;

    private String address;
    private String phoneNumber;
    private String email;
    private Date birthDate;
    private String SNSNumber;
    private String citizenCardNumber;
    /**
     * The Sdf that parses the user birth Date.
     */
    SimpleDateFormat sdf;

    /**
     * Instantiates a new Sns user dto.
     *
     * @param name              the name
     * @param address           the address
     * @param phoneNumber       the phone number
     * @param email             the email
     * @param birthDate         the birth date
     * @param SNSNumber         the sns number
     * @param citizenCardNumber the citizen card number
     */
    public SNSUserDTO(String name, String address, String phoneNumber, String email, Date birthDate, String SNSNumber, String citizenCardNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
        this.SNSNumber = SNSNumber;
        this.citizenCardNumber = citizenCardNumber;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
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
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Gets sns number.
     *
     * @return the sns number
     */
    public String getSNSNumber() {
        return SNSNumber;
    }

    /**
     * Gets citizen card number.
     *
     * @return the citizen card number
     */
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

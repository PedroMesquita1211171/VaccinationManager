package app.DTO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * The type Sns user dto.
 *
 * @author Henrique Pinto - 1211201
 */
public class SNSUserDTO implements Serializable {
    private String name;
    private String address;
    private String sex;
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
     * @param sex               the sex
     * @param phoneNumber       the phone number
     * @param email             the email
     * @param birthDate         the birthdate
     * @param SNSNumber         the sns number
     * @param citizenCardNumber the citizen card number
     */
    public SNSUserDTO(String name, String address, String sex,String phoneNumber, String email, Date birthDate, String SNSNumber, String citizenCardNumber){
        this.name = name;
        this.address = address;
        this.sex = sex;
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
     * Gets birthdate.
     *
     * @return the birthdate
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

    /**
     * Gets Sex
     *
     * @return the sex
     */
    public String getSex(){
        return this.sex;
    }

    /**
     * returns age of SNSUser in years
     *
     * @return age of SNSUser in years
     */
    public int getAge(){
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(birthDate.getYear()+1900, birthDate.getMonth()+1, birthDate.getDate());
        long years = java.time.temporal.ChronoUnit.YEARS.between( birthday , today );
        return (int)years;
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

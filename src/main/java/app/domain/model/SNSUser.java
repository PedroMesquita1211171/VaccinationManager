package app.domain.model;

import app.domain.shared.Constants;

import java.lang.invoke.ConstantBootstraps;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author Henrique Pinto - 1211201
 */
public class SNSUser {

    /**
     * SNSUser Attributes
     */

    private String name;
    private String address;
    private String gender;
    private String phoneNumber;
    private String email;
    private Date birthDate;
    private String SNSNumber;
    private String citizenCardNumber;


    /**
     * Instantiates a new SNSUser.
     *
     * @param name              the name
     * @param address           the address
     * @param genderOption      the gender option
     * @param phoneNumber       the phone number
     * @param email             the email
     * @param birthDate         the birthdate
     * @param SNSNumber         the sns number
     * @param citizenCardNumber the citizen card number
     */
    public SNSUser(String name, String address, String genderOption, String phoneNumber, String email, Date birthDate, String SNSNumber, String citizenCardNumber){
        checkNameRules(name);
        checkAddressRules(address);
        checkPhoneNumber(phoneNumber);
        checkEmail(email);
        checkCitizenCardNumber(citizenCardNumber);
        checkSNSNumber(SNSNumber);
        checkGenderRules(genderOption);

        this.name = name;
        this.address = address;
        this.gender = genderOption;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
        this.SNSNumber = SNSNumber;
        this.citizenCardNumber = citizenCardNumber;
    }

    /**
     * Check name Rules
     *
     * @param name
     */

    private void checkNameRules(String name){
        if(name.length() < 3 || name.length() > 20){
            throw new IllegalArgumentException("Name is too short");
        }
    }

    /**
     * Check address rules.
     * @param address
     */
    private void checkAddressRules(String address){
        if(address.length() < 2 || address.length() > 40){
            throw new IllegalArgumentException("Address is too short");
        }
    }

    /**
     * Check gender rules
     *
     * @param genderOption
     */
    private void checkGenderRules(String genderOption){
        if(!(genderOption.equalsIgnoreCase("male")||genderOption.equalsIgnoreCase("female")||genderOption.equalsIgnoreCase("non-binary")||genderOption.equalsIgnoreCase("none"))){
            throw new IllegalArgumentException("Invalid Gender Option");
        }
    }

    /**
     * Check if phoneNumber is valid
     *
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
     * Check if SNSNumber is valid
     * @param SNSNumber
     */
    private void checkSNSNumber(String SNSNumber){
        String SNSNumberRegex = "^[0-9]{9}$";

        Pattern pattern = Pattern.compile(SNSNumberRegex);

        if(!pattern.matcher(SNSNumber).matches()){
            throw new IllegalArgumentException("Invalid SNS Number");
        }
    }

    /**
     * check if Email is valid
     *
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
     * Check if citizenCardNumber is valid
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
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
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

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets birth date.
     *
     * @param birthDate the birth date
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Sets sns number.
     *
     * @param SNSNumber the sns number
     */
    public void setSNSNumber(String SNSNumber) {
        this.SNSNumber = SNSNumber;
    }

    /**
     * Sets citizen card number.
     *
     * @param citizenCardNumber the citizen card number
     */
    public void setCitizenCardNumber(String citizenCardNumber) {
        this.citizenCardNumber = citizenCardNumber;
    }

    /**
     *
     * returns the SNSUser object as a string
     *
     * @return SNSUser
     */
    @Override
    public String toString() {
        return  "\nInfo: " + "\n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Gender: " + gender + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email: " + email + "\n" +
                "Birth Date: " + birthDate + "\n" +
                "SNS Number: " + SNSNumber + "\n" +
                "Citizen Card Number: " + citizenCardNumber + "\n\n";
    }
}

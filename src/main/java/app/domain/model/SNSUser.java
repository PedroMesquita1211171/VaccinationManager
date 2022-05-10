package app.domain.model;

import java.util.Calendar;
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
    private String birthDate;
    private String SNSNumber;
    private String citizenCardNumber;

    private static final String GENDER_BY_DEFAULT = "UNDEFINED";

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
    public SNSUser(String name, String address, String genderOption, String phoneNumber, String email, String birthDate, String SNSNumber, String citizenCardNumber){
        checkNameRules(name);
        checkAddressRules(address);
        checkPhoneNumber(phoneNumber);
        checkEmail(email);
        checkCitizenCardNumber(citizenCardNumber);
        checkSNSNumber(SNSNumber);

        this.name = name;
        this.address = address;
        this.gender = checkGenderRules(genderOption);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
        this.SNSNumber = SNSNumber;
        this.citizenCardNumber = citizenCardNumber;
    }

    /**
     *
     * Checkers(used to verify if SNSUser's parameters are valid)
     *
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

    private String checkGenderRules(String genderOption){
        if (genderOption.equals("1")){
            return "male";
        } else if (genderOption.equals("2")) {
            return "female";
        } else if (genderOption.equals("3")) {
            return "non-binary";
        } else {
            return GENDER_BY_DEFAULT;
        }
    }

    private void checkPhoneNumber2(String phoneNumber){
        String phoneNumberRegex = "^[0-9]{8}$";
        String phoneNumber8last = phoneNumber.substring(1);
        System.out.println(phoneNumber8last);

        Pattern pattern = Pattern.compile(phoneNumberRegex);
        if(!pattern.matcher(phoneNumber8last).matches() && phoneNumber.charAt(0) != '9'){
            throw new IllegalArgumentException("Invalid Phone Number");
        }
    }

    private void checkPhoneNumber(String phoneNumber){
        if(phoneNumber.length() != 9 || phoneNumber.charAt(0) != '9'){
            throw new IllegalArgumentException("Invalid Phone Number");
        }
    }

    private void checkSNSNumber(String SNSNumber){
        String SNSNumberRegex = "^[0-9]{9}$";

        Pattern pattern = Pattern.compile(SNSNumberRegex);

        if(!pattern.matcher(SNSNumber).matches()){
            throw new IllegalArgumentException("Invalid SNS Number");
        }
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
    public String getBirthDate() {
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

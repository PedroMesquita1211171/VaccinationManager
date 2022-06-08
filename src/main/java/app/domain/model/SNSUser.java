package app.domain.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * The type Sns user.
 *
 * @author Henrique Pinto - 1211201
 */
public class SNSUser {

    /**
     * SNSUser Attributes
     */

    private String name;
    private String address;
    private String sex;
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
     * @param sex               the sex option
     * @param phoneNumber       the phone number
     * @param email             the email
     * @param birthDate         the birthdate
     * @param SNSNumber         the sns number
     * @param citizenCardNumber the citizen card number
     */
    public SNSUser(String name, String address, String sex, String phoneNumber, String email, Date birthDate, String SNSNumber, String citizenCardNumber){
        checkNameRules(name);
        checkAddressRules(address);
        checkPhoneNumber(phoneNumber);
        checkEmail(email);
        checkCitizenCardNumber(citizenCardNumber);
        checkSNSNumber(SNSNumber);
        checkSex(sex);

        this.name = name;
        this.address = address;
        if(sex.equalsIgnoreCase("")||sex.equalsIgnoreCase("none")){
            this.sex = "Not Specified";
        }else{
            this.sex = sex;
        }

        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
        this.SNSNumber = SNSNumber;
        this.citizenCardNumber = citizenCardNumber;
    }

    /**
     * Check name Rules
     *
     * @param name the name
     */

    private void checkNameRules(String name){
        if(name.length() < 3 ){
            throw new IllegalArgumentException("Name is too short");
        }else if(name.length() > 100){
            throw new IllegalArgumentException("Name is too long");
        }
    }

    /**
     * Check address rules.
     * @param address the address
     */
    private void checkAddressRules(String address){
        if(address.length() < 3){
            throw new IllegalArgumentException("Address is too short");
        }else if(address.length() > 300){
            throw new IllegalArgumentException("Address is too long");
        }
    }

    /**
     * Check sex rules
     *
     * @param sex the sex
     */
    private void checkSex(String sex){
        if(!(sex.equalsIgnoreCase("male")||sex.equalsIgnoreCase("female")||sex.equalsIgnoreCase("non-binary")||sex.equalsIgnoreCase("none")||sex.equalsIgnoreCase("")||sex.equalsIgnoreCase("Feminino")||sex.equalsIgnoreCase("Masculino")||sex.equalsIgnoreCase("n/a"))){
            throw new IllegalArgumentException("Invalid Gender Option");
        }
    }

    /**
     * Check if phoneNumber is valid
     *
     * @param phoneNumber the phone number
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
     * @param SNSNumber the SNSNumber
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
     * @param email the email
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
     * @param citizenCardNumber the citizenCardNumber
     */
    private void checkCitizenCardNumber(String citizenCardNumber) {
        String citizenCardNumberRegex = "^[0-9]{8}$";

        Pattern pattern = Pattern.compile(citizenCardNumberRegex);

        if (!pattern.matcher(citizenCardNumber).matches()) {
            throw new IllegalArgumentException("Invalid Citizen Card Number");
        }
    }
    private void checkBirthDate(Date birthDate){
        if(birthDate.after(new Date())){
            throw new IllegalArgumentException("Invalid Birth Date");
        }
        if(birthDate.getMonth() == 1 && birthDate.getDate() > 29){
            throw new IllegalArgumentException("Invalid Birth Date");
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
     * Gets sex.
     *
     * @return the sex
     */
    public String getSex() {
        return sex;
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
     * Sets sex.
     *
     * @param sex the sex
     */
    public void setSex(String sex) {
        this.sex = sex;
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
     * Sets birthdate.
     *
     * @param birthDate the birthdate
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
     * returns age of SNSUser in years
     *
     * @return age of SNSUser in years
     */
    public int getAge(){
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(birthDate.getYear()+1900, birthDate.getMonth()+1, birthDate.getDate());
        Period period = Period.between(birthday, today);
        return period.getYears();
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
                "Gender: " + sex + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email: " + email + "\n" +
                "Birth Date: " + birthDate + "\n" +
                "SNS Number: " + SNSNumber + "\n" +
                "Citizen Card Number: " + citizenCardNumber + "\n\n";
    }

    /**
     *  Equals method
     * @param o the object to compare
     * @return true if the SNSUser object is equal to the parameter
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SNSUser snsUser = (SNSUser) o;
        return Objects.equals(phoneNumber, snsUser.phoneNumber) && Objects.equals(email, snsUser.email) && Objects.equals(SNSNumber, snsUser.SNSNumber) && Objects.equals(citizenCardNumber, snsUser.citizenCardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, email, SNSNumber, citizenCardNumber);
    }
}

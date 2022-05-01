package app.domain.model;

public class SNSUser {

    private String name;
    private String address;
    private String gender;
    private String phoneNumber;
    private String email;
    private String birthDate;
    private String SNSNumber;
    private String citizenCardNumber;

    private static final String GENDER_BY_DEFAULT = "UNDEFINED";

    public SNSUser(String name, String address, String genderOption, String phoneNumber, String email, String birthDate, String SNSNumber, String citizenCardNumber){
        checkNameRules(name);
        checkAddressRules(address);
        checkPhoneNumber(phoneNumber);
        this.name = name;
        this.address = address;
        this.gender = checkGenderRules(genderOption);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
        this.SNSNumber = SNSNumber;
        this.citizenCardNumber = citizenCardNumber;
    }

    private void checkNameRules(String name){
        if(name.length() < 3){
            throw new IllegalArgumentException("Name is too short");
        }
    }

    private void checkAddressRules(String address){
        if(address.length() < 2){
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

    private void checkPhoneNumber(String phoneNumber){
        if(phoneNumber.charAt(0) != '9' && phoneNumber.length() != 9){
            throw new IllegalArgumentException("Invalid Phone Number");
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
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
        return  "\nInfo: " +
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

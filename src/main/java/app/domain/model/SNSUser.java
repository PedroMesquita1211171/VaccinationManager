package app.domain.model;

public class SNSUser {

    private String name;
    private String address;
    private String gender;
    private String phoneNumber;
    private String email;
    private String birthDate;
    private String SNSNumber;
    private String CCNumber;

    private static final String GENDER_BY_DEFAULT = "UNDEFINED";

    public SNSUser(String name, String address, int genderOption, String phoneNumber, String email, String birthDate, String SNSNumber, String CCNumber){
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
        this.CCNumber = CCNumber;
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

    private String checkGenderRules(int genderOption){
        if (genderOption == 1) {
            return "male";
        } else if (genderOption == 2) {
            return "female";
        } else if (genderOption == 3) {
            return "non-binary";
        } else if (genderOption == 4) {
            return GENDER_BY_DEFAULT;
        } else {
            throw new IllegalArgumentException("Invalid Gender");
        }
    }

    private void checkPhoneNumber(String phoneNumber){
     if(phoneNumber.charAt(0) != '9' && phoneNumber.length() != 9){
         throw new IllegalArgumentException("Invalid Phone Number");
       }
    }


}

package app.controller;

import app.domain.model.Company;
import app.domain.model.SNSUser;


/**
 * @author Henrique Pinto - 1211201
 */
public class SpecifyNewSNSUserController {


    /**
     *
     * Company and SNSUser to add.
     */
    private Company company;
    private SNSUser snsu;


    /**
     *Constructors.
     */
    public SpecifyNewSNSUserController(){
        this(App.getInstance().getCompany());
    }


    public SpecifyNewSNSUserController(Company company) {
        this.company = company;
        this.snsu = null;
    }

    /**
     * Creates and verifies sns user.
     *
     * @param name              the name
     * @param address           the address
     * @param genderOption      the gender option
     * @param phoneNumber       the phone number
     * @param email             the email
     * @param birthDate         the birthdate
     * @param SNSNumber         the sns number
     * @param citizenCardNumber the citizen card number
     * @return the boolean
     */
    public boolean createSNSUser(String name, String address, String genderOption, String phoneNumber, String email, String birthDate, String SNSNumber, String citizenCardNumber){
        try{
            this.snsu = new SNSUser(name, address, genderOption, phoneNumber, email, birthDate, SNSNumber, citizenCardNumber);
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return false;
        }


        return validateSNSUser();
    }

    /**
     * Saves sns user.
     */
    public void saveSNSUser(){
        this.company.addSNSUser(snsu);
    }

    /**
     * Shows sns user function.
     *
     * @return the SNSUser info in a string format
     */
    public String showSNSUser(){
        return this.snsu.toString();
    }

    /**
     * Validates sns user boolean.
     *
     * @return if user is valid or not
     */
    public boolean validateSNSUser(){
        if(this.snsu == null)return false;
        if(company.getSNSUserStore().getSNSUserList().contains(this.snsu)) return false;
        for (SNSUser other : company.getSNSUserStore().getSNSUserList()) {
            if(other.getSNSNumber().equals(this.snsu.getSNSNumber()) || other.getCitizenCardNumber().equals(this.snsu.getCitizenCardNumber()) || other.getEmail().equals(this.snsu.getEmail()) || other.getPhoneNumber().equals(this.snsu.getPhoneNumber())){
                return false;
            }
        }
        return true;
    }

}
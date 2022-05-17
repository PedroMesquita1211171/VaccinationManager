package app.controller;

import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.domain.shared.Constants;
import app.ui.console.utils.Generators;


/**
 * @author Henrique Pinto - 1211201
 */
public class RegisterSNSUserController {


    /**
     *
     * Company and SNSUser to add.
     */
    private Company company;
    private SNSUser snsu;


    /**
     *Constructors.
     */
    public RegisterSNSUserController(){
        this(App.getInstance().getCompany());
    }


    public RegisterSNSUserController(Company company) {
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
            this.snsu = this.company.getSNSUserStore().createSNSUser(name, address, genderOption, phoneNumber, email, birthDate, SNSNumber, citizenCardNumber);
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return false;
        }


        return this.company.getSNSUserStore().validateSNSUser(this.snsu);
    }

    /**
     * Saves sns user.
     */
    public void saveSNSUser(){
        String password = Generators.generateRandomPassword();
        this.company.getSNSUserStore().addSNSUser(snsu);
        this.company.getAuthFacade().addUserWithRole(snsu.getName(), snsu.getEmail(),password, Constants.ROLE_SNSUSER);
    }

    /**
     * Shows sns user function.
     *
     * @return the SNSUser info in a string format
     */
    public String showSNSUser(){
        return this.snsu.toString();
    }
}
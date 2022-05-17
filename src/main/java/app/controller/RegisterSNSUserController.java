package app.controller;

import app.DTO.Mappers.SNSUserMapper;
import app.DTO.SNSUserDTO;
import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.domain.shared.Constants;
import app.ui.console.utils.Generators;
import app.ui.console.utils.Utils;

import java.text.ParseException;
import java.util.Date;


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
    public boolean createSNSUser(String name, String address, String genderOption, String phoneNumber, String email, Date birthDate, String SNSNumber, String citizenCardNumber){
        try{
            this.snsu = this.company.getSNSUserStore().createSNSUser(name, address, genderOption, phoneNumber, email, birthDate, SNSNumber, citizenCardNumber);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
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

        System.out.println("\nSNS User" +"\n" + "Name: " + snsu.getName() + "\n" + "Email: " + snsu.getEmail() + "\n" + "Password: " + password + "\n");
    }

    /**
     * Shows sns user function.
     *
     * @return the SNSUser info in a DTO Format
     */
    public SNSUserDTO showSNSUser(){
        return SNSUserMapper.toDTO(this.snsu);
    }
}
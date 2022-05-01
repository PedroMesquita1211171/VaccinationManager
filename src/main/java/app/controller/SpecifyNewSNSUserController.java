package app.controller;

import app.domain.model.Company;
import app.domain.model.SNSUser;


public class SpecifyNewSNSUserController {

    private Company company;
    private SNSUser snsu;

    public SpecifyNewSNSUserController(){
        this(App.getInstance().getCompany());
    }

    public SpecifyNewSNSUserController(Company company) {
        this.company = company;
        this.snsu = null;
    }

    public boolean createSNSUser(String name, String address, String genderOption, String phoneNumber, String email, String birthDate, String SNSNumber, String citizenCardNumber){
        this.snsu = new SNSUser(name, address, genderOption, phoneNumber, email, birthDate, SNSNumber, citizenCardNumber);
        return validateSNSUser();
    }

    public void saveSNSUser(){
        this.company.addSNSUser(snsu);
    }

    public String showSNSUser(){
        return this.snsu.toString();
    }

    public boolean validateSNSUser(){
        for (SNSUser other : company.getSNSUserStore().getSNSUserList()) {
            if(other.getSNSNumber().equals(this.snsu.getSNSNumber()) || other.getCitizenCardNumber().equals(this.snsu.getCitizenCardNumber()) || other.getEmail().equals(this.snsu.getEmail()) || other.getPhoneNumber().equals(this.snsu.getPhoneNumber())){
                return false;
            }
        }
        return true;
    }

}
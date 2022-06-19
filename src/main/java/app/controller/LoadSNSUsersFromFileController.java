package app.controller;

import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.domain.shared.Constants;
import app.ui.console.utils.Generators;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Load sns users from file controller.
 */
public class LoadSNSUsersFromFileController {

       private Company company;
       private List<SNSUser> SNSUserList;

    /**
     * Instantiates a new Load sns users from file controller.
     *
     * @param company the company
     */
    public LoadSNSUsersFromFileController(Company company) {
              this.company = company;
              this.SNSUserList = new ArrayList<>();
       }

    /**
     * Instantiates a new Load sns users from file controller.
     */
    public LoadSNSUsersFromFileController() {
            this(App.getInstance().getCompany());
       }

    /**
     * Create sns user list.
     *
     * @param name              the name
     * @param address           the address
     * @param sex               the sex
     * @param phoneNumber       the phone number
     * @param email             the email
     * @param birthDate         the birth date
     * @param SNSNumber         the sns number
     * @param citizenCardNumber the citizen card number
     */
    public void createSNSUserList(String name, String address, String sex, String phoneNumber, String email, Date birthDate, String SNSNumber, String citizenCardNumber){
           this.SNSUserList.add(this.company.getSNSUserStore().createSNSUser(name, address, sex, phoneNumber, email, birthDate, SNSNumber, citizenCardNumber));
       }

    /**
     * Save sns user list.
     */
    public void saveSNSUserList(){
           for (SNSUser snsu :this.SNSUserList) {
               String password = Generators.generateRandomPassword();

               boolean a =  this.company.getSNSUserStore().addSNSUser(snsu);
               boolean b = this.company.getAuthFacade().addUserWithRole(snsu.getName(), snsu.getEmail(),password, Constants.ROLE_SNSUSER);

               if(a && b){
                   System.out.println("\nSNS User" +"\n" + "Name: " + snsu.getName() + "\n" + "Email: " + snsu.getEmail() + "\n" + "Password: " + password + "\n");
               }

           }
       }
}

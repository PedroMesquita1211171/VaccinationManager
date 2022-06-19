package app.domain.Store;

import app.domain.model.SNSUser;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Sns user store.
 *
 * @author Henrique Pinto - 1211201
 */
public class SNSUserStore {

    /**
     * List that will store SNSUsers
     */

    private List<SNSUser> snsUserList;

    /**
     * Declares the snsUserList as an ArrayList of type SNSUser.
     */
    public SNSUserStore() {
        this.snsUserList = new ArrayList<>();
    }

    /**
     * Is used for returning the List of SNSUsers.
     *
     * @return the sns user list
     */
    public List<SNSUser> getSNSUserList() {
        return snsUserList;
    }

    /**
     * Adds sns user into the List.
     *
     * @param snsu the SNSUser
     * @return the boolean
     */
    public boolean addSNSUser(SNSUser snsu) {
        if(validateSNSUser(snsu)){
            this.snsUserList.add(snsu);
            return true;
        }
        return false;
    }

    /**
     * Validates sns user boolean.
     *
     * @param snsu the snsu
     * @return if user is valid or not
     */
    public boolean validateSNSUser(SNSUser snsu) {
        if(snsu == null)return false;
        if(getSNSUserList().contains(snsu)) return false;
        for (SNSUser other : getSNSUserList()) {
            if(other.getSNSNumber().equals(snsu.getSNSNumber()) || other.getCitizenCardNumber().equals(snsu.getCitizenCardNumber()) || other.getEmail().equals(snsu.getEmail()) || other.getPhoneNumber().equals(snsu.getPhoneNumber())){
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a SNSUser Object.
     *
     * @param name              the name
     * @param address           the address
     * @param genderOption      the gender option
     * @param phoneNumber       the phone number
     * @param email             the email
     * @param birthDate         the birth date
     * @param SNSNumber         the sns number
     * @param citizenCardNumber the citizen card number
     * @return the SNSUser object created
     */
    public SNSUser createSNSUser(String name, String address, String genderOption, String phoneNumber, String email, Date birthDate, String SNSNumber, String citizenCardNumber) {
        return new SNSUser(name, address, genderOption, phoneNumber, email, birthDate, SNSNumber, citizenCardNumber);
    }

    /**
     * Used for US03
     *
     * @param userEmail email for login
     * @param pwd       password for login
     * @param role      assigned to work
     * @return an email with the required information to login.
     */
    public boolean sendAccessDataViaEmail(String userEmail, String pwd, String role) {
        String designation = "DGS/SNS";
        if (userEmail == null || userEmail.isEmpty() || pwd == null || pwd.isEmpty() || role == null || role.isEmpty())
            return false;

        File emailFile = new File("emailAndSMSMessages.txt");

        try (FileWriter writer = new FileWriter(emailFile, true)) {
            writer.write(String.format("From: %s%nTo: %s%nMessage: Dear %s, your password to gain access to our system is %s%n" +
                    "Message Type: Email%n%n", designation, userEmail, role, pwd));
            System.out.print("All data has been sent to your email !\n");
            return true;
        } catch (Exception ex) {
            Logger.getGlobal().log(Level.SEVERE, ex.getMessage());
        }

        return false;
    }

    /**
     * Returns Logged in User. If not Logged in returns null.
     *
     * @param email the email
     * @return the sns user
     */
    public SNSUser returnLoggedSNSUser(String email){
        for (SNSUser snsu : this.snsUserList) {
            if(snsu.getEmail().equals(email)) return snsu;
        }
        return null;
    }

    public void setSNSUserList(List<SNSUser> userList) {
        this.snsUserList = userList;
    }
}

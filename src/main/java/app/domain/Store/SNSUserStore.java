package app.domain.Store;

import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;

/**
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
     */
    public void addSNSUser(SNSUser snsu) {
        this.snsUserList.add(snsu);
    }

    /**
     * Validates sns user boolean.
     *
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
     * @return the SNSUser object created
     */
    public SNSUser createSNSUser(String name, String address, String genderOption, String phoneNumber, String email, String birthDate, String SNSNumber, String citizenCardNumber) {
        return new SNSUser(name, address, genderOption, phoneNumber, email, birthDate, SNSNumber, citizenCardNumber);
    }

}

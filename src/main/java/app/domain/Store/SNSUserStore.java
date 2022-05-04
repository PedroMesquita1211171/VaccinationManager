package app.domain.Store;

import app.domain.model.SNSUser;

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
     * Adds sns user.
     *
     * @param snsu the SNSUser
     */
    public void addSNSUser(SNSUser snsu) {
        this.snsUserList.add(snsu);
    }
}

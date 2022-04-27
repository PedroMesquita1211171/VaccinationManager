package app.domain.Store;

import app.domain.model.SNSUser;

import java.util.ArrayList;
import java.util.List;

public class SNSUserStore {

    private List<SNSUser> snsUserList;

    public SNSUserStore() {
        this.snsUserList = new ArrayList<>();
    }

    public List<SNSUser> getSNSUserList() {
        return snsUserList;
    }

    public void addSNSUser(SNSUser snsu) {
        this.snsUserList.add(snsu);
    }
}

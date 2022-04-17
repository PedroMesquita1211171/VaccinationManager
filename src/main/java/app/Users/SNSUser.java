package app.Users;

public class SNSUser extends User {
    private String SnsNumber;


    public SNSUser(String username, String password) {
        super(username, password);
    }

    public SNSUser(String username, String password, String snsNumber) {
        super(username, password);
        this.SnsNumber = snsNumber;
    }

    public String showSnsNumber() {
        return SnsNumber;
    }

    public void changeSnsNumber(String snsNumber) {

        SnsNumber = snsNumber;
    }
}

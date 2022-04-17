package app.Users;

public class SNSUser extends User {
    private String SnsNumber;


    public SNSUser(String username, String password) {
        super(username, password);
    }

    public SNSUser(String username, String password, String snsNumber) {
        super(username, password);
        changeSnsNumber(snsNumber);
    }

    public String showSnsNumber() {
        return SnsNumber;
    }

    public void changeSnsNumber(String snsNumber) {
        if(snsNumber.length() == 11) {
            this.SnsNumber = snsNumber;
        }else if(snsNumber == null){
            throw new NullPointerException();
        }else if(snsNumber.length() != 11){
            throw new IllegalArgumentException();
          }
        }
}

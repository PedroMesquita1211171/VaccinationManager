package app.Users;

import java.util.Objects;

public abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        changeUsername(username);
        changePassword(password);
    }

    public String showUsername() {
        return this.username;
    }

    public String showPassword() {
        return this.password;
    }

    public void changeUsername(String username) {
            if(username.isBlank()) {
                throw new IllegalArgumentException();
            }else if(username == null){
                throw new NullPointerException();
            } else{
                this.username = username;
            }
    }

    public void changePassword(String password) {
            if(password.isBlank()) {
                throw new IllegalArgumentException();
            }else if(password == null) {
                throw new NullPointerException();
            } else{
                this.password = password;
            }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

}

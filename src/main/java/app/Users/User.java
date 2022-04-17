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
        try{
            if(username.isEmpty()) {
                throw new IllegalArgumentException();
            }else{
                this.username = username;
            }
        }catch (IllegalArgumentException e) {
            System.out.println("Username cannot be empty!");
        }

    }

    public void changePassword(String password) {
        try {
            if(password.isEmpty()) {
                throw new IllegalArgumentException();
            }else{
                this.password = password;
            }
        }catch (IllegalArgumentException e) {
            System.out.println("Password cannot be empty!");
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

package services.login_complete;

public class LoginCompleteInputData {

    final private String username;
    final private String password;

    public LoginCompleteInputData(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

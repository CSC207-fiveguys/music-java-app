package services.signup_complete;

public class SignupCompleteInputData {
    final private String username;

    final private String password1;

    final private String password2;

    public SignupCompleteInputData(String username, String password1, String password2) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }
}

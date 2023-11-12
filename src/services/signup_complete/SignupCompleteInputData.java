package services.signup_complete;

public class SignupCompleteInputData {
    final private String username;

    final private String password;

    public SignupCompleteInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public  String getPassword(){
        return password;
    }
}

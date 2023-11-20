package services.login_complete;

public class LoginCompleteOutputData {

  private final String username;
  private boolean loginFailed;

  public LoginCompleteOutputData(String username, boolean loginFailed) {
    this.username = username;
    this.loginFailed = loginFailed;
  }

  public String getUsername() {
    return username;
  }
}

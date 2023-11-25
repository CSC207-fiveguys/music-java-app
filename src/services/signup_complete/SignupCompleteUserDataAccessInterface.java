package services.signup_complete;
import entities.User;

public interface SignupCompleteUserDataAccessInterface {
    boolean exists(String identifier);
    void saveUser(User user);
    User getUser(String username);
}

package services.signup_complete;
import entities.User;

public interface SignupCompleteUserDataAccessInterface {
    boolean existsByName(String identifier);
    void save(String user, String pass);
    User get(String username);
}

package services.login_complete;
import entities.User;

public interface LoginCompleteUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}

package services.login_complete;

import entities.User;

public interface LoginCompleteUserDataAccessInterface {

  boolean exists(String identifier);

  void saveUser(User user);

  User getUser(String username);
}

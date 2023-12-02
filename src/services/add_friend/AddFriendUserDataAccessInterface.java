package services.add_friend;

import entities.User;

public interface AddFriendUserDataAccessInterface {

  boolean exists(String identifier);

  void saveUser(User user);

  User getUser(String username);
}


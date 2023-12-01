package services.remove_friend;

import entities.User;

public interface RemoveFriendDataAccessInterface {

  public User getUser(String username);

  public void saveUser(User user);

  public boolean exists(String username);

}

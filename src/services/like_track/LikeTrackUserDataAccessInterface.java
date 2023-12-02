package services.like_track;

import entities.User;

public interface LikeTrackUserDataAccessInterface {
  boolean exists(String username);
  void saveUser(User user);
  User getUser(String username);
}

package services.unfollow_artist;

import entities.User;
import java.util.ArrayList;

public interface UnfollowArtistUserDataAccessInterface {
  public User getUser(String username);

  public void saveUser(User user);
  public boolean exists(String username);

  private void save() {
  }

  public ArrayList<String> searchUser(String query);

}

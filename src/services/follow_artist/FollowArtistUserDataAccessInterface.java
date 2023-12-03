package services.follow_artist;

import entities.User;
import java.util.ArrayList;

public interface FollowArtistUserDataAccessInterface {

  public User getUser(String username);

  public ArrayList<String> searchUser(String query);

}

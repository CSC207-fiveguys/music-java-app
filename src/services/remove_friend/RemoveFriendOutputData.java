package services.remove_friend;

import entities.User;
import java.util.ArrayList;
import java.util.List;

public class RemoveFriendOutputData {
  public final ArrayList<String> userFriends;

  public RemoveFriendOutputData(ArrayList<String> userFriends) {
    this.userFriends = userFriends;
  }
}

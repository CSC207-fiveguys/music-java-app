package services.remove_friend;

import entities.User;
import java.util.ArrayList;
import java.util.List;

public interface RemoveFriendOutputBoundary {

  void prepareSuccessView(RemoveFriendOutputData userFriends);

  void prepareFailView();

}

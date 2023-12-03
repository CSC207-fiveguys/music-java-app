package services.search;

import entities.User;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class SearchAlgorithmContains implements SearchAlgorithm{

  @Override
  public ArrayList<String> searchUser(String searchQuery, Map<String, User> users) {
    ArrayList<String> matchingUsers = new ArrayList<>();
    for (String user : users.keySet()) {
      if (searchQuery.contains(user) || user.contains(searchQuery)) {
        matchingUsers.add(user);
      }
    }
    return matchingUsers;
  }
}

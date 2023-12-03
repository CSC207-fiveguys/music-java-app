package services.search;

import data_access.UserDataAccessObject;
import entities.User;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public interface SearchAlgorithm {

  ArrayList<String> searchUser(String searchQuery, Map<String, User> users);
}

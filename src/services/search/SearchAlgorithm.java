package services.search;

import data_access.UserDataAccessObject;
import java.util.ArrayList;

public interface SearchAlgorithm {

  ArrayList<String> searchUser(String searchQuery);
}

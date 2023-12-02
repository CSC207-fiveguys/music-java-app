package data_access;

import entities.User;
import entities.UserFactory;
import java.util.ArrayList;
import services.login_complete.LoginCompleteUserDataAccessInterface;
import services.signup_complete.SignupCompleteUserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class UserDataAccessObject implements LoginCompleteUserDataAccessInterface, SignupCompleteUserDataAccessInterface {

    private final Map<String, User> users;

    public final UserFactory userFactory;

    public UserDataAccessObject(UserFactory userFactory) {
        this.userFactory = userFactory;
        users = new HashMap<>();
        // The DataAccessObject stores the usernames and User objects of all the users so far
        // This data is kept in a json file
        // Create 2 fake users and store them in users
        User fake_user1 = userFactory.create("_Jason", "pass123");
        User fake_user2 = userFactory.create("bob445", "bananaPASS");
        users.put(fake_user1.getUsername(), fake_user1);
        users.put(fake_user2.getUsername(), fake_user2);

        // TODO: Read from the json file that stores User information
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public void saveUser(User user) {
        // Add the user to the dictionary and then update the json file
        users.put(user.getUsername(), user);
        save();
    }

    public boolean exists(String username) {
        return users.containsKey(username);
    }

    private void save() {
        // Write the user data from users to the json file
        // TODO Implement this method
    }

    public ArrayList<String> searchUser(String query){

        ArrayList<String> matchingUsers = new ArrayList<>();
        for (String user: users.keySet()){
            if (query.contains(user) || user.contains(query)){
                matchingUsers.add(user);
            }
        }
        return matchingUsers;
    }

}

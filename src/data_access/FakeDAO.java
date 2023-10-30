package data_access;

import java.util.HashMap;
import java.util.Map;

public class FakeDAO {

    private final Map<String, String> users;

    public FakeDAO() {
        users = new HashMap<>();
        // add 2 fake users
        users.put("_Jason", "pass123");
        users.put("bob445", "bananaPASS");
    }

    /**
     * @return password or null if username not found
     */
    public String getPassword(String username) {
        return users.get(username);
    }

    public void saveUser(String username, String password) {
        users.put(username, password);
    }
}

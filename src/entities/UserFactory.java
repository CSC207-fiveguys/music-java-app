package entities;

public class UserFactory {

    public User create(String username, String password){
        return new CommonUser(username, password);
    }

}

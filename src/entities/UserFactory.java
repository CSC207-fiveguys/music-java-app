package entities;

public class UserFactory {

    public User create(String name, String password){
        return new CommonUser(name, password);
    }
}

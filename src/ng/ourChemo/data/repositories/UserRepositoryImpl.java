package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;

import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {
    ArrayList<User> users = new ArrayList<>();

    @Override
    public long count() {
        long count = 0;
        return ++count;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public User findByUsername(String userName) {
        String usernameToLowercase = userName.toLowerCase();
        for (User foundUser : users){
            if(foundUser.getUsername().equals(usernameToLowercase)) {
                return foundUser;
            }
        }
        return null;
    }


}

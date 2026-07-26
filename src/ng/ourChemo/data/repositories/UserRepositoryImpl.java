package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;

import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {
    ArrayList<User> users = new ArrayList<>();

    @Override
    public long count() {
        long count =  users.size();
        return count;
    }

    @Override
    public String save(User user) {
        users.add(user);
        return "User saved successfully";
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

    @Override
    public void saveNewUser(User newUser) {
        for(User user : users){
            if (user.getUsername().equals(newUser.getUsername()))   {
                System.out.println("User already exists");
                return;
            }
        }
        save(newUser);
    }

    @Override
    public void delete(User user) {
        User foundUser = findByUsername(user.getUsername());
        users.remove(foundUser);
    }

    @Override
    public void clearAll() {
       while(!users.isEmpty()){
           delete(users.get(0));
        }
    }

    @Override
    public User findById(int userId) {
        User foundUser = null;
        for (User user : users) {
            if (user.getUserId() == userId) {
                foundUser = user;
            }
        }
            return foundUser;
    }


}

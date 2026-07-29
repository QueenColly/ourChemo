package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;

import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {
   private  ArrayList<User> users = new ArrayList<>();
   private  int count = 0;

    @Override
    public long count() {
        return users.size();
    }

    @Override
    public User save(User user) {
        if(user.getUserId()!=0){
            users.remove(user.getUserId()-1);
            users.add(user.getUserId()-1,user);
            return user;
        }
        user.setUserId(++count);
        users.add(user);
        return user;
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
        --count;
    }

    @Override
    public void clearAll() {
       while(!users.isEmpty()){
          users.clear();
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

    @Override
    public void deleteById(int userTwoId) {
        User foundUser = findById(userTwoId);
        users.remove(foundUser);
    }

    @Override
    public void updateExisting(User user) {
        User foundUser = findById(user.getUserId());

        foundUser.setFullname(user.getFullname());
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());

        save(foundUser);
    }


}

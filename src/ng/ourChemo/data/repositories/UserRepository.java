package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;

public interface UserRepository {
    long count();
    String save(User user);
    User findByUsername(String userName);

    void saveNewUser(User newUser);

    void delete(User user);

    void clearAll();

    User findById(int userId);
}

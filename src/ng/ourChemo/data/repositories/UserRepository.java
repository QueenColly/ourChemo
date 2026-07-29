package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;

public interface UserRepository {
    long count();
    User save(User user);
    User findByUsername(String userName);

    void saveNewUser(User newUser);

    void delete(User user);

    void clearAll();

    User findById(int userId);

    void deleteById(int userTwoId);

    void updateExisting(User user);
}

package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;

public interface UserRepository {
    long count();
    void save(User user);
    User findByUsername(String userName);
}

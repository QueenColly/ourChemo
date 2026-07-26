package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryImplTest {

    @Test
    public void createANewUserAndSaveToSystem_test() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();

        user.setLoggedIn(false);
        user.setUserId(1234);
        user.setPassword("1234");
        user.setFullname("Queen Colly");
        user.setUsername("colly");

        String response = userRepository.save(user);
        assertEquals("User saved successfully", response);
    }

    @Test
    public void saveANewUserToTheListOfUsers_test() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();

        user.setLoggedIn(false);
        user.setUserId(1234);
        user.setPassword("1234");
        user.setFullname("Queen Colly");
        user.setUsername("colly");
        userRepository.save(user);

        User user2 = new User();
        user2.setUserId(123);
        user2.setPassword("124");
        user2.setFullname("Colly");
        user2.setUsername("coy");
        user.setLoggedIn(false);
        userRepository.saveNewUser(user2);

        assertEquals(2, userRepository.count());
    }

    @Test
    public void saveThreeNewUsers_deleteUserObject() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();

        user.setLoggedIn(false);
        user.setUserId(1234);
        user.setPassword("1234");
        user.setFullname("Queen Colly");
        user.setUsername("colly");
        userRepository.save(user);

        User user2 = new User();
        user2.setUserId(123);
        user2.setPassword("124");
        user2.setFullname("Colly");
        user2.setUsername("coy");
        user.setLoggedIn(false);
        userRepository.saveNewUser(user2);

        User user3 = new User();
        user3.setUserId(123);
        user3.setPassword("1224");
        user3.setFullname("Collyy");
        user3.setUsername("cooy");
        user.setLoggedIn(false);
        userRepository.saveNewUser(user3);
        assertEquals(3, userRepository.count());

        userRepository.delete(user2);
        assertEquals(2, userRepository.count());

    }

    @Test
    public void saveTwoUsers_clearTheListOfSavedUsers_test() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();

        user.setLoggedIn(false);
        user.setUserId(1234);
        user.setPassword("1234");
        user.setFullname("Queen Colly");
        user.setUsername("colly");
        userRepository.save(user);

        User user2 = new User();
        user2.setUserId(123);
        user2.setPassword("124");
        user2.setFullname("Colly");
        user2.setUsername("coy");
        user.setLoggedIn(false);
        userRepository.saveNewUser(user2);

        assertEquals(2, userRepository.count());
        userRepository.clearAll();
        assertEquals(0, userRepository.count());
    }

    @Test
    public void saveANewUserToTheList_findUserById_test() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();

        user.setLoggedIn(false);
        user.setUserId(1234);
        user.setPassword("1234");
        user.setFullname("Queen Colly");
        user.setUsername("colly");
        userRepository.save(user);

        User userOne = userRepository.findById(user.getUserId());
        assertEquals(1, userRepository.count());
        assertEquals(userOne.getUsername(), user.getUsername());
    }

    @Test
    public void saveANewUserToTheList_deleteUserById_test() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
    }
}
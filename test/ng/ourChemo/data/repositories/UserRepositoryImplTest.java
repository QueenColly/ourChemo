package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryImplTest {

    private UserRepository userRepository;
    private User user;

    @BeforeEach
        public void setup(){
        userRepository  = new UserRepositoryImpl();
        user = new User();

        user.setLoggedIn(false);
        user.setPassword("1234");
        user.setFullname("Queen Colly");
        user.setUsername("Colly");
        userRepository.save(user);

    }

    @AfterEach
    public void after(){
        userRepository.clearAll();
    }

    @Test
    public void createANewUserAndSaveToSystem_test() {
        User user1 = new User();
        user1.setLoggedIn(false);
        user1.setPassword("12345");
        user1.setFullname("Achalugo");
        user1.setUsername("Asa");
        userRepository.save(user1);
        assertEquals(2, userRepository.count());
        assertEquals("Asa",user1.getUsername());
    }

    @Test
    public void saveANewUserToTheListOfUsers_countHasIncreasedTo_one__test() {

        User user2 = new User();
        user2.setPassword("124");
        user2.setFullname("Colly");
        user2.setUsername("coy");
        user.setLoggedIn(false);
        userRepository.saveNewUser(user2);

        assertEquals(2, userRepository.count());
    }

    @Test
    public void saveThreeNewUsers_deleteUser2Object_listNowHas_TwoUser_test() {
        User user2 = new User();
        user2.setPassword("124");
        user2.setFullname("Colly");
        user2.setUsername("coy");
        user.setLoggedIn(false);
        userRepository.saveNewUser(user2);

        User user3 = new User();
        user3.setPassword("1224");
        user3.setFullname("Collyy");
        user3.setUsername("cooy");
        user.setLoggedIn(false);
        userRepository.saveNewUser(user3);
        assertEquals(3, userRepository.count());

        userRepository.delete(user2);
        assertEquals(2, userRepository.count());

    }
//
    @Test
    public void saveTwoUsers_clearTheListOfSavedUsers_listIsEmpty_test() {
        User user2 = new User();
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
        User userOne = userRepository.findById(user.getUserId());
        assertEquals(1, userRepository.count());
        assertEquals(userOne.getUsername(), user.getUsername());
    }

    @Test
    public void saveANewUserToTheList_deleteUserById_test() {
        User user2 = new User();
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

        int userTwoId  = user2.getUserId();
        userRepository.deleteById(userTwoId);
        assertEquals(2, userRepository.count());
    }
    @Test
        public void saveANewUser_updatingExistingUserInformation(){
        user.setLoggedIn(false);
        user.setPassword("1234");
        user.setFullname("Queen Collins");
        user.setUsername("colly");

        userRepository.updateExisting(user);
        assertEquals(1, userRepository.count());
        assertEquals("colly", (userRepository.findById(user.getUserId())).getUsername());
    }
}
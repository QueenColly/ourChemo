package ng.ourChemo.services;

import ng.ourChemo.data.repositories.UserRepository;
import ng.ourChemo.data.repositories.UserRepositoryImpl;
import ng.ourChemo.dtos.requests.RegisterUserRequest;

import static org.junit.jupiter.api.Assertions.*;

import ng.ourChemo.dtos.responses.RegisterUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthServiceImplTest {

    private AuthService authService;
    private UserRepository userRepository;
    private RegisterUserRequest registerUserRequest;

    @BeforeEach
    public void setup(){
    authService = new AuthServiceImpl();
    userRepository = new UserRepositoryImpl();
    registerUserRequest = new RegisterUserRequest();

    registerUserRequest.setFullName("Collete Umeh");
    registerUserRequest.setUsername("QueenColly");
    registerUserRequest.setPassword("strongpassword");
    }

    @Test
        public void registerUser_userHasAnAccount_userCountIs1_test(){
            RegisterUserResponse response = authService.registerUser(registerUserRequest);

            assertEquals(1, userRepository.count());
        }

    @Test
        public void userHasRegistered_userLogsIn_userIsLoggedIn_test(){
            authService.registerUser(registerUserRequest);
            String userIsLoggedIn = authService.login("QueenColly", "strongpassword");

            assertEquals("Logged in successfully", userIsLoggedIn);
        }

    @Test
        public void userHasRegistered_userIsLoggedIn_andLogsOut_userIsLoggedOut_test(){
        authService.registerUser(registerUserRequest);
        String userIsLoggedOut = authService.logout("QueenColly");

        assertEquals("Logged out successfully", userIsLoggedOut);
        }

    @Test
        public void userHasRegistered_userLogsInWithCorrectUserNameInUpperCase_andCorrectPassword_userIsLoggedIn_test(){
        authService.registerUser(registerUserRequest);
        String userLoggedIn = authService.login("QUEENCOLLY", "strongpassword");

        assertEquals("Logged in successfully", userLoggedIn);
    }

    @Test
        public void userHasRegistered_userLogsInWithWrongUserNameInUpperCase_andCorrectPassword_userIsLoggedIn_throwAnException_test(){
        authService.registerUser(registerUserRequest);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> authService.login("Esther", "strongpassword"));
        String actual = exception.getMessage();
        String expected = "Invalid username or password";

        assertEquals(actual, expected);
    }
    @Test
        public void userHasRegistered_userLogsInWith_CorrectUserNameInUpperCase_andWrongPassword_throwAnException_test(){
        authService.registerUser(registerUserRequest);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> authService.login("QueenColly", "password"));
        String actual = exception.getMessage();
        String expected = "Invalid username or password";

        assertEquals(actual, expected);
    }

}

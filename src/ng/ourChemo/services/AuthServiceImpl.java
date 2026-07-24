package ng.ourChemo.services;

import ng.ourChemo.data.models.User;
import ng.ourChemo.data.repositories.UserRepository;
import ng.ourChemo.data.repositories.UserRepositoryImpl;
import ng.ourChemo.dtos.requests.RegisterUserRequest;
import ng.ourChemo.dtos.responses.RegisterUserResponse;

import java.util.Random;

public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        User user = new User();
        String usernameToLowercase = registerUserRequest.getUsername().toLowerCase();
        user.setFullname(registerUserRequest.getFullName());
        user.setUsername(usernameToLowercase);
        user.setPassword(registerUserRequest.getPassword());

        int id = setUserId();
        user.setUserId(id);

        userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setResponse("User registered successfully");
        return response;
    }

    @Override
    public String login(String username, String password) {
        String usernameToLowercase = username.toLowerCase();
        User foundUser = userRepository.findByUsername(usernameToLowercase);
        if(foundUser != null && password.equals(foundUser.getPassword())){
            foundUser.setLoggedIn(true);
            userRepository.save(foundUser);
            return "Logged in successfully";
        }
        else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }

    @Override
    public String logout(String username) {
        String usernameToLowercase = username.toLowerCase();
        User foundUser = userRepository.findByUsername(usernameToLowercase);
        foundUser.setLoggedIn(false);
        userRepository.save(foundUser);
        return "Logged out successfully";
    }

    private int setUserId(){
        Random random = new Random();
        int id = random.nextInt(1, 100);
        return id;
    }
}

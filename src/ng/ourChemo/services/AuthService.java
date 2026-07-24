package ng.ourChemo.services;

import ng.ourChemo.data.models.User;
import ng.ourChemo.dtos.requests.RegisterUserRequest;
import ng.ourChemo.dtos.responses.RegisterUserResponse;

public interface AuthService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);

    String login(String username, String password);

    String logout(String username);
}

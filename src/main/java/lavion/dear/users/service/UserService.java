package lavion.dear.users.service;

import lavion.dear.users.dto.UserRequest;
import lavion.dear.users.dto.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse createUser(UserRequest user);

    Optional<UserResponse> updateUser(String userName, UserRequest userRequest);

    List<UserResponse> getAllUsers();

    Optional<UserResponse> getUser(String userName);

    Optional<UserResponse> deleteUser(String userName);


}

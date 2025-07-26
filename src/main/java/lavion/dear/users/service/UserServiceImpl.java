package lavion.dear.users.service;

import lavion.dear.users.dto.UserResponse;
import lavion.dear.users.mapper.UserMapper;
import lavion.dear.users.model.User;
import lavion.dear.users.repository.UserRepository;
import lavion.dear.users.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        //check for username uniqueness
        if (repository.existsById(userRequest.getUserName())) {
            System.out.println("Existing user: "+userRequest.getUserName());
        }

        User user = mapper.toUser(userRequest);
        User saved = repository.save(user);
        return mapper.toUserResponse(saved);
    }

    @Override
    public Optional<UserResponse> updateUser(String userName, UserRequest userRequest) {
        return repository.findById(userName).map(user -> {
            mapper.update(userRequest, user);
            User saved = repository.save(user);
            return mapper.toUserResponse(saved);
        });
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = repository.findAll();
        return mapper.toUserResponseList(users);
    }

    @Override
    public Optional<UserResponse> getUser(String userName) {
        return repository.findById(userName)
                .map(mapper::toUserResponse);
    }

    @Override
    public Optional<UserResponse> deleteUser(String username) {
        return repository.findById(username)
                .map(user -> {
                    repository.deleteById(username);
                    return mapper.toUserResponse(user);
                });
    }
}

package lavion.dear.service;

import lavion.dear.dto.user.UserResponse;
import lavion.dear.mapper.UserMapper;
import lavion.dear.model.User;
import lavion.dear.repository.UserRepository;
import lavion.dear.dto.user.UserRequest;
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

        User user = mapper.toEntity(userRequest);
        User saved = repository.save(user);
        return (UserResponse) mapper.toDtoResponse(saved);
    }

    @Override
    public Optional<UserResponse> updateUser(String userName, UserRequest userRequest) {
        return repository.findById(userName).map(user -> {
            mapper.updateEntityFromDtoRequest(userRequest, user);
            User saved = repository.save(user);
            return (UserResponse) mapper.toDtoResponse(saved);
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
                .map(user -> (UserResponse) mapper.toDtoResponse(user));
    }

    @Override
    public Optional<UserResponse> deleteUser(String username) {
        return repository.findById(username)
                .map(user -> {
                    repository.deleteById(username);
                    return (UserResponse) mapper.toDtoResponse(user);
                });
    }
}

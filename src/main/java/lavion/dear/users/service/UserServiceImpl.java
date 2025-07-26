package lavion.dear.users.service;

import lavion.dear.users.mapper.UserMapper;
import lavion.dear.users.model.User;
import lavion.dear.users.repository.UserRepository;
import lavion.dear.users.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public void createUser(UserRequest userRequest) {
        if (userRequest != null) {
            User user = mapper.toUser(userRequest);
            repository.save(user); // Handles both insert and update
        }
    }
}

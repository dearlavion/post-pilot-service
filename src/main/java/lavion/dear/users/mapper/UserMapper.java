package lavion.dear.users.mapper;

import lavion.dear.users.dto.UserRequest;
import lavion.dear.users.dto.UserResponse;
import lavion.dear.users.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserRequest userRequest);
    UserResponse toUserResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(UserRequest dto, @MappingTarget User entity);

    List<UserResponse> toUserResponseList(List<User> users);
}

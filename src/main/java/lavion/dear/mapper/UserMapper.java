package lavion.dear.mapper;

import lavion.dear.common.EntityMapper;
import lavion.dear.dto.user.UserDTO;
import lavion.dear.dto.user.UserResponse;
import lavion.dear.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
    List<UserResponse> toUserResponseList(List<User> users);

    /*User toUser(UserRequest userRequest);
    UserResponse toUserResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(UserRequest dto, @MappingTarget User entity);

    List<UserResponse> toUserResponseList(List<User> users);*/
}

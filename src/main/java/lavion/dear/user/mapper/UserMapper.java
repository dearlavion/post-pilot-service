package lavion.dear.user.mapper;

import lavion.dear.common.EntityMapper;
import lavion.dear.user.dto.UserDTO;
import lavion.dear.user.dto.UserRequest;
import lavion.dear.user.dto.UserResponse;
import lavion.dear.user.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

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

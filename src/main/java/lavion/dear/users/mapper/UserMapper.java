package lavion.dear.users.mapper;

import lavion.dear.users.dto.UserRequest;
import lavion.dear.users.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserRequest userRequest);
}

package lavion.dear.filter.user;

import lavion.dear.dto.user.UserRequest;

public interface BaseUser {
    boolean test(UserRequest user);
}

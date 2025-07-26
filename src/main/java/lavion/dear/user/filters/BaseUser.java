package lavion.dear.user.filters;

import lavion.dear.user.dto.UserRequest;

public interface BaseUser {
    boolean test(UserRequest user);
}

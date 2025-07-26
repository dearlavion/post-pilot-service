package lavion.dear.users.filters;

import lavion.dear.users.dto.UserRequest;

public interface BaseUser {
    boolean test(UserRequest user);
}

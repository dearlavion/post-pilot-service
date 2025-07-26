package lavion.dear.users.filters;

import lavion.dear.users.dto.UserRequest;

public class SimpleUser implements BaseUser {
    @Override
    public boolean test(UserRequest user) {
        return false;
    }
}

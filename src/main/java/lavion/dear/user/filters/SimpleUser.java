package lavion.dear.user.filters;

import lavion.dear.user.dto.UserRequest;

public class SimpleUser implements BaseUser {
    @Override
    public boolean test(UserRequest user) {
        return false;
    }
}

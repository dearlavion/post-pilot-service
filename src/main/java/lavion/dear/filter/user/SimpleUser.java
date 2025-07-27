package lavion.dear.filter.user;

import lavion.dear.dto.user.UserRequest;
import lavion.dear.filter.user.BaseUser;

public class SimpleUser implements BaseUser {
    @Override
    public boolean test(UserRequest user) {
        return false;
    }
}

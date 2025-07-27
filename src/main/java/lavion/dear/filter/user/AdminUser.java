package lavion.dear.filter.user;

import lavion.dear.dto.user.UserRequest;

public class AdminUser implements BaseUser {
    @Override
    public boolean test(UserRequest user) {
        return false;
    }
}

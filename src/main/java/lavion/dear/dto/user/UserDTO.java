package lavion.dear.dto.user;

import lavion.dear.enums.NotificationChannel;
import lavion.dear.enums.UserRole;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    @NonNull
    private String userName;
    private String name;
    private String password;
    private List<UserRole> roles;
    private List<NotificationChannel> notificationChannels;
}

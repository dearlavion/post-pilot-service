package lavion.dear.users.dto;

import lavion.dear.notification.model.NotificationChannel;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UserRequest {
    @NonNull
    private String userName;
    private String firstName;
    private String lastName;
    private List<NotificationChannel> notificationChannels;
}

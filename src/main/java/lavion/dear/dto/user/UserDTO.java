package lavion.dear.dto.user;

import lavion.dear.model.Notification;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    @NonNull
    private String userName;
    private String firstName;
    private String lastName;
    private List<Notification> notifications;
    private boolean isAdmin;
}

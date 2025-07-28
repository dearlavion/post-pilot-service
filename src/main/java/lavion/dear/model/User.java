package lavion.dear.model;

import lavion.dear.enums.NotificationChannel;
import lavion.dear.enums.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Getter
@Setter
public class User {
    @Id
    private String userName;
    private String name;
    private String password;
    private List<UserRole> roles;
    private List<NotificationChannel> notificationChannels;
}

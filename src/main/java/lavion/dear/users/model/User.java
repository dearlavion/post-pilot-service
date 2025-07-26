package lavion.dear.users.model;

import lavion.dear.notification.model.NotificationChannel;
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
    private String firstName;
    private String lastName;
    private List<NotificationChannel> notificationChannels;
}

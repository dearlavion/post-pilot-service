package lavion.dear.authentication;

import lavion.dear.dto.user.UserRequest;
import lavion.dear.enums.NotificationChannel;
import lavion.dear.enums.UserRole;
import lavion.dear.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminUserInitializer implements CommandLineRunner {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AdminUserInitializer(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        //other option is to use mongock
        if (!userService.existByUserName("admin")) {
            UserRequest admin = new UserRequest();
            admin.setUserName("admin");
            admin.setName("bae");
            admin.setPassword("admin");//will be hashed on createUser
            admin.setRoles(List.of(UserRole.ADMIN, UserRole.USER));
            admin.setNotificationChannels(List.of(NotificationChannel.EMAIL, NotificationChannel.SMS));
            userService.createUser(admin);
        }
    }
}

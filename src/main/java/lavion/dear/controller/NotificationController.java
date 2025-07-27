package lavion.dear.controller;

import lavion.dear.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    private NotificationService notificationChannelService;

    @GetMapping("/")
    public String home() {
        return "Welcome!";
    }
}

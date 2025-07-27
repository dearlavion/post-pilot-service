package lavion.dear.service;

import lavion.dear.filter.notification.BaseChannel;

public interface NotificationService {
    String sendNotification(BaseChannel notification);
    //List<> getNotificationChannels();
}

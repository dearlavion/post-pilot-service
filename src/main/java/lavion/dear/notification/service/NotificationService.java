package lavion.dear.notification.service;

import lavion.dear.notification.filters.BaseChannel;

public interface NotificationService {
    String sendNotification(BaseChannel notification);
    //List<> getNotificationChannels();
}

package lavion.dear.notification.filters;

import lavion.dear.notification.model.NotificationChannel;

public interface BaseChannel {
    boolean test(NotificationChannel notificationChannel);
}

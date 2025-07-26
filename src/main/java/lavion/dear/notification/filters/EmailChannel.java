package lavion.dear.notification.filters;

import lavion.dear.notification.filters.BaseChannel;
import lavion.dear.notification.model.NotificationChannel;

public class EmailChannel implements BaseChannel {
    @Override
    public boolean test(NotificationChannel notificationChannel) {
        return false;
    }
}

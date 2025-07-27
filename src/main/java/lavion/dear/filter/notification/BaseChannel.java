package lavion.dear.filter.notification;

import lavion.dear.model.Notification;

public interface BaseChannel {
    boolean test(Notification notification);
}

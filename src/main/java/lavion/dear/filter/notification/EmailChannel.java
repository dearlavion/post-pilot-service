package lavion.dear.filter.notification;

import lavion.dear.model.Notification;

public class EmailChannel implements BaseChannel {
    @Override
    public boolean test(Notification notification) {
        return false;
    }
}

package lavion.dear.enums;

public enum NotificationChannel {
    SMS("SMS"),
    EMAIL("EMAIL");

    private final String value;

    NotificationChannel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static NotificationChannel fromValue(String value) {
        for (NotificationChannel channel : values()) {
            if (channel.value.equalsIgnoreCase(value)) {
                return channel;
            }
        }
        throw new IllegalArgumentException("Unknown channel: " + value);
    }
}

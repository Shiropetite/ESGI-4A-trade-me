package com.archi.trademe.application.signals;

public class NotificationSender extends SignalSender<NotificationListener, String> {

    private static NotificationSender instance;

    private NotificationSender() { }

    public static NotificationSender getInstance() {
        if (instance == null) {
            instance = new NotificationSender();
        }
        return instance;
    }

    @Override
    public void raise(String message) {
        getInstance().getListeners().forEach(listener -> listener.onNotify(message));
    }

}

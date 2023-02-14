package com.archi.trademe.logger;

import com.archi.trademe.application.signals.NotificationListener;

public class InAppLogger implements NotificationListener {

    private static InAppLogger instance;

    private InAppLogger() {}

    public static InAppLogger getInstance() {
        if (instance == null) {
            instance = new InAppLogger();
        }
        return instance;
    }

    @Override
    public void onNotify(String message) {
        System.out.println(message);
    }

}

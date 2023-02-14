package com.archi.trademe.application.signals;

import java.util.ArrayList;
import java.util.List;

/**
 * Can send signal for every listener
 * @param <T> : type of listener
 * @param <Config> : Config that sent to the listener
 */
public abstract class SignalSender<T, Config> {

    private final List<T> listeners = new ArrayList<>();

    public abstract void raise(Config config);

    public void register(T listener) { this.listeners.add(listener); }

    public void unregister(T listener) { this.listeners.remove(listener); }

    public List<T> getListeners() { return listeners; }
}

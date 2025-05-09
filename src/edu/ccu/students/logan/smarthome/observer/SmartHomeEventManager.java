package edu.ccu.students.logan.smarthome.observer;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeEventManager {
    private List<SmartHomeObserver> observers = new ArrayList<>();

    public void subscribe(SmartHomeObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(SmartHomeObserver observer) {
        observers.remove(observer);
    }

    // Notifies all observers of the given event.
    public void notify(String event) {
        System.out.println("Event Manager: Notifying observers about event: " + event);
        for (SmartHomeObserver observer : observers) {
            observer.update(event);
        }
    }
}


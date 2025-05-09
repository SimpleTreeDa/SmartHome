package edu.ccu.students.logan.smarthome.events;

import edu.ccu.students.logan.smarthome.SmartDevice;
import java.util.ArrayList;
import java.util.List;

public class DeviceEventPublisher {
    private List<SmartHomeObserver> observers = new ArrayList<>();

    public void addObserver(SmartHomeObserver o) {
        observers.add(o);
    }

    public void notifyChange(SmartDevice device) {
        for (SmartHomeObserver o : observers) {
            o.onDeviceStateChanged(device);
        }
    }
}
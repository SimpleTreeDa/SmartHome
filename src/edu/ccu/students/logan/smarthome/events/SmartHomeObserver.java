package edu.ccu.students.logan.smarthome.events;

import edu.ccu.students.logan.smarthome.SmartDevice;

public interface SmartHomeObserver {
    void onDeviceStateChanged(SmartDevice device);
}
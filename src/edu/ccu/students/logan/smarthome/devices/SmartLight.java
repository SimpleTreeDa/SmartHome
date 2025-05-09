package edu.ccu.students.logan.smarthome.devices;

import edu.ccu.students.logan.smarthome.core.SmartDevice;
import edu.ccu.students.logan.smarthome.core.Powerable;
import edu.ccu.students.logan.smarthome.observer.SmartHomeObserver;

public class SmartLight implements SmartDevice, SmartHomeObserver, Powerable {
    private String name;
    private boolean isOn;

    public SmartLight(String name) {
        this.name = name;
        this.isOn = false;
    }
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(name + " is turned on.");
    }
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(name + " is turned off.");
    }

    @Override
    public String getName() {
        return name;
    }

    // Reacts to events – for example, turning on when a "motion_detected" event is received.
    @Override
    public void update(String event) {
        if (event.equalsIgnoreCase("motion_detected")) {
            turnOn();
        }
    }
    @Override
    public boolean isOn() {
        return isOn;
    }
}


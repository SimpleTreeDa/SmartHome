package edu.ccu.students.logan.smarthome.decorator;

import edu.ccu.students.logan.smarthome.core.Powerable;


public abstract class PowerUsageTrackerDecorator implements Powerable {
// PowerUsageTrackerDecorator abstract class
// TODO: This class should go in: edu.ccu.students.<username>.smarthome.decorator
    protected Powerable device;

    public PowerUsageTrackerDecorator(Powerable device) {
        // TODO: initialize with a device
    }

    @Override
    public void turnOn() {
        // TODO: start tracking and delegate
    }

    @Override
    public void turnOff() {
        // TODO: stop tracking and delegate
    }

    @Override
    public boolean isOn() {
        // TODO: return power state
        return false;
    }
}

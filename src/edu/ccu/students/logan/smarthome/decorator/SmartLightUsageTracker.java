package edu.ccu.students.logan.smarthome.decorator;

import edu.ccu.students.logan.smarthome.core.SmartDevice;
import edu.ccu.students.logan.smarthome.devices.SmartLight;

public class SmartLightUsageTracker implements SmartDevice {
    private SmartLight smartLight;
    private long totalActiveTime; // in milliseconds
    private long startTime;
    private boolean isTracking;

    public SmartLightUsageTracker(SmartLight smartLight) {
        this.smartLight = smartLight;
        this.totalActiveTime = 0;
        this.isTracking = false;
    }

    // Wrap the turnOn() call and start tracking time.
    public void turnOn() {
        if (!isTracking) {
            startTime = System.currentTimeMillis();
            isTracking = true;
        }
        smartLight.turnOn();
    }

    // Wrap the turnOff() call and update total active time.
    public void turnOff() {
        if (isTracking) {
            long elapsed = System.currentTimeMillis() - startTime;
            totalActiveTime += elapsed;
            isTracking = false;
        }
        smartLight.turnOff();
    }

    public long getTotalActiveTime() {
        return totalActiveTime;
    }

    @Override
    public String getName() {
        return smartLight.getName();
    }
}

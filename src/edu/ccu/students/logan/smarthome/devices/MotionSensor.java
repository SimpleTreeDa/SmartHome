package edu.ccu.students.logan.smarthome.devices;
import edu.ccu.students.logan.smarthome.core.SmartDevice;
import edu.ccu.students.logan.smarthome.observer.SmartHomeObserver;

public class MotionSensor implements SmartDevice, SmartHomeObserver {
    private String name;

    public MotionSensor(String name) {
        this.name = name;
    }

    public void detectMotion() {
        System.out.println(name + " detected motion!");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(String event) {
        if (event.equalsIgnoreCase("check_motion")) {
            detectMotion();
        }
    }
}

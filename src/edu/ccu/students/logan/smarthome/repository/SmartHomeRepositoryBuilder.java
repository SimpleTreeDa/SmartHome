package edu.ccu.students.logan.smarthome.repository;
import edu.ccu.students.logan.smarthome.core.SmartDevice;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeRepositoryBuilder {
    private List<SmartDevice> devices = new ArrayList<>();

    public SmartHomeRepositoryBuilder addDevice(SmartDevice device) {
        devices.add(device);
        return this;
    }

    public SmartHomeRepository build() {
        return new SmartHomeRepository(devices);
    }
}

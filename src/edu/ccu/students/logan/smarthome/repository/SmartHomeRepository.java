package edu.ccu.students.logan.smarthome.repository;

import edu.ccu.students.logan.smarthome.core.SmartDevice;
import java.util.List;

public class SmartHomeRepository {
    private List<SmartDevice> devices;

    public SmartHomeRepository(List<SmartDevice> devices) {
        this.devices = devices;
    }

    public List<SmartDevice> getDevices() {
        return devices;
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }
}

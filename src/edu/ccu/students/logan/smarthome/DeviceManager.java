package edu.ccu.students.logan.smarthome;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeviceManager {
    private Map<String, SmartDevice> devices = new HashMap<>();

    public void addDevice(SmartDevice device) {
        devices.put(device.getName(), device);
        System.out.println(device.getName() + " added");
    }

    public void removeDevice(String name) {
        devices.remove(name);
        System.out.println(name + " removed");
    }

    public void turnAllOn() {
        devices.values().forEach(SmartDevice::turnOn);
    }

    public void turnAllOff() {
        devices.values().forEach(SmartDevice::turnOff);
    }

    public SmartDevice getDevice(String name) {
        return devices.get(name);
    }

    public Set<String> listDeviceNames() {
        return new HashSet<>(devices.keySet());
    }
}
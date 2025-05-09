package edu.ccu.students.logan.smarthome;

public interface SmartDevice {
    String getName();
    void turnOn();
    void turnOff();
    boolean isOn();
}
package edu.ccu.students.logan.smarthome;

public class SmartLight implements SmartDevice {
    private String name;
    private boolean on;

    public SmartLight(String name) {
        this.name = name;
        this.on = false;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void turnOn() {
        on = true;
        System.out.println(name + " turned ON");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println(name + " turned OFF");
    }

    @Override
    public boolean isOn() { return on; }
}
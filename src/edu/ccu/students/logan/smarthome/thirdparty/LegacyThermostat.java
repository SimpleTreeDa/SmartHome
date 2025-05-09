package edu.ccu.students.logan.smarthome.thirdparty;

public class LegacyThermostat {
    private String label;
    private boolean enabled;

    public LegacyThermostat(String label) {
        this.label = label;
        this.enabled = false;
    }

    public String getLabel() { return label; }
    public void enable() { enabled = true; System.out.println(label + " enabled"); }
    public void disable() { enabled = false; System.out.println(label + " disabled"); }
    public boolean status() { return enabled; }
}
package edu.ccu.students.logan.smarthome.adapters;

import edu.ccu.students.logan.smarthome.SmartDevice;
import edu.ccu.students.logan.smarthome.thirdparty.LegacyThermostat;

public class ThermostatAdapter implements SmartDevice {
    private LegacyThermostat legacy;

    public ThermostatAdapter(LegacyThermostat legacy) {
        this.legacy = legacy;
    }

    @Override
    public String getName() { return legacy.getLabel(); }

    @Override
    public void turnOn() { legacy.enable(); }

    @Override
    public void turnOff() { legacy.disable(); }

    @Override
    public boolean isOn() { return legacy.status(); }
}
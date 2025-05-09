package edu.ccu.students.logan.smarthome.ui;

import edu.ccu.students.logan.smarthome.*;
import edu.ccu.students.logan.smarthome.events.*;
import edu.ccu.students.logan.smarthome.adapters.*;
import edu.ccu.students.logan.smarthome.thirdparty.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JFrame implements SmartHomeObserver {
    private DeviceManager manager = new DeviceManager();
    private DeviceEventPublisher publisher = new DeviceEventPublisher();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> deviceList = new JList<>(listModel);

    public ControlPanel() {
        super("Smart Home Control Panel");
        publisher.addObserver(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel btnPanel = new JPanel();
        JButton addLight = new JButton("Add Light");
        addLight.addActionListener(e -> addLight());
        btnPanel.add(addLight);

        JButton addThermostat = new JButton("Add Thermostat");
        addThermostat.addActionListener(e -> addThermostat());
        btnPanel.add(addThermostat);

        JButton toggle = new JButton("Toggle Selected");
        toggle.addActionListener(e -> toggleSelected());
        btnPanel.add(toggle);

        add(new JScrollPane(deviceList), BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }

    private void addLight() {
        SmartLight light = new SmartLight("Light-" + System.currentTimeMillis());
        manager.addDevice(light);
        listModel.addElement(light.getName());
        publisher.notifyChange(light);
    }

    private void addThermostat() {
        LegacyThermostat legacy = new LegacyThermostat("Thermostat-" + System.currentTimeMillis());
        try {
            SmartDevice adapted = AdapterLoader.loadAdapter("edu.ccu.students.logan.smarthome.adapters.ThermostatAdapter", legacy);
            manager.addDevice(adapted);
            listModel.addElement(adapted.getName());
            publisher.notifyChange(adapted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void toggleSelected() {
        String name = deviceList.getSelectedValue();
        if (name == null) return;
        SmartDevice d = manager.getDevice(name);
        if (d.isOn()) d.turnOff(); else d.turnOn();
        publisher.notifyChange(d);
    }

    @Override
    public void onDeviceStateChanged(SmartDevice device) {
        System.out.println("Event: " + device.getName() + " is now " + (device.isOn() ? "ON" : "OFF"));
    }
}
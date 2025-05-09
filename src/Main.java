package edu.ccu.students.logan.smarthome;

import edu.ccu.students.logan.smarthome.adapters.AdapterLoader;
import edu.ccu.students.logan.smarthome.thirdparty.LegacyThermostat;
import edu.ccu.students.logan.smarthome.ui.ControlPanel;

import javax.swing.SwingUtilities;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("gui")) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ControlPanel().setVisible(true);
                }
            });
        } else {
            runCLI();
        }
    }

    private static void runCLI() {
        DeviceManager manager = new DeviceManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Commands: add-light, add-thermostat, list, on <name>, off <name>, all-on, all-off, exit");
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            switch (parts[0]) {
                case "add-light":
                    SmartLight light = new SmartLight("Light-" + System.currentTimeMillis());
                    manager.addDevice(light);
                    break;
                case "add-thermostat":
                    LegacyThermostat legacy = new LegacyThermostat("Thermostat-" + System.currentTimeMillis());
                    try {
                        SmartDevice t = AdapterLoader.loadAdapter(
                            "edu.ccu.students.logan.smarthome.adapters.ThermostatAdapter", legacy);
                        manager.addDevice(t);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "list":
                    manager.listDeviceNames().forEach(System.out::println);
                    break;
                case "on":
                    if (parts.length > 1) {
                        SmartDevice d = manager.getDevice(parts[1]);
                        if (d != null) d.turnOn();
                    }
                    break;
                case "off":
                    if (parts.length > 1) {
                        SmartDevice d = manager.getDevice(parts[1]);
                        if (d != null) d.turnOff();
                    }
                    break;
                case "all-on":
                    manager.turnAllOn();
                    break;
                case "all-off":
                    manager.turnAllOff();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}
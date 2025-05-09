package edu.ccu.students.logan.smarthome.controller;

import edu.ccu.students.logan.smarthome.repository.SmartHomeRepository;
import edu.ccu.students.logan.smarthome.core.SmartDevice;
import edu.ccu.students.logan.smarthome.observer.SmartHomeEventManager;

public class HomeController {
    private static HomeController instance = null;
    private SmartHomeRepository repository;
    private SmartHomeEventManager eventManager;

    // Private constructor so that no other instance can be created.
    private HomeController(SmartHomeRepository repository, SmartHomeEventManager eventManager) {
        this.repository = repository;
        this.eventManager = eventManager;
    }

    // getInstance ensures only one instance is created.
    public static HomeController getInstance(SmartHomeRepository repository, SmartHomeEventManager eventManager) {
        if(instance == null) {
            instance = new HomeController(repository, eventManager);
        }
        return instance;
    }

    public void addDevice(SmartDevice device) {
        repository.addDevice(device);
    }

    // When an event occurs in the home, notify all subscribed observers.
    public void triggerEvent(String event) {
        System.out.println("HomeController triggering event: " + event);
        eventManager.notify(event);
    }
}

package edu.ccu.students.logan.smarthome.adapters;

import edu.ccu.students.logan.smarthome.SmartDevice;
import java.lang.reflect.Constructor;

public class AdapterLoader {
    /**
     * Dynamically load an adapter class given its name and the device instance.
     */
    @SuppressWarnings("unchecked")
    public static SmartDevice loadAdapter(String className, Object device) throws Exception {
        Class<?> clazz = Class.forName(className);
        Constructor<?> ctor = clazz.getConstructor(device.getClass());
        return (SmartDevice) ctor.newInstance(device);
    }
}
package edu.ccu.students.logan.smarthome.decorator;

import edu.ccu.students.logan.smarthome.core.Powerable;


public class UsageTrackerPowerableDevice extends PowerUsageTrackerDecorator {
// UsageTrackerPowerableDevice class
// TODO: This class should go in: edu.ccu.students.<username>.smarthome.decorator
    public UsageTrackerPowerableDevice(Powerable device) {
        super(device);
        // TODO: initialize tracker
    }

    public long getTotalUsageTime() {
        // TODO: calculate total usage time
        return 0;
    }
}

public class MainTest {

    // Helper assertion methods.
    private static void assertTrue(String message, boolean condition) {
        if (!condition) {
            throw new RuntimeException("Assertion failed: " + message);
        }
    }

    private static void assertFalse(String message, boolean condition) {
        if (condition) {
            throw new RuntimeException("Assertion failed: " + message);
        }
    }

    private static void assertEquals(String message, Object expected, Object actual) {
        if ((expected == null && actual != null) || (expected != null && !expected.equals(actual))) {
            throw new RuntimeException("Assertion failed: " + message + ". Expected: " + expected + ", Actual: " + actual);
        }
    }

    private static void assertSame(String message, Object expected, Object actual) {
        if (expected != actual) {
            throw new RuntimeException("Assertion failed: " + message);
        }
    }

    // Test for Singleton pattern in HomeController.
    public static void testSingletonHomeController() {
        // Creating an empty repository using the Builder.
        java.util.ArrayList devices = new java.util.ArrayList();
        edu.ccu.students.logan.smarthome.repository.SmartHomeRepository repo = new edu.ccu.students.logan.smarthome.repository.SmartHomeRepository(devices);
        edu.ccu.students.logan.smarthome.observer.SmartHomeEventManager eventManager = new edu.ccu.students.logan.smarthome.observer.SmartHomeEventManager();
        edu.ccu.students.logan.smarthome.controller.HomeController controller1 = edu.ccu.students.logan.smarthome.controller.HomeController.getInstance(repo, eventManager);
        edu.ccu.students.logan.smarthome.controller.HomeController controller2 = edu.ccu.students.logan.smarthome.controller.HomeController.getInstance(repo, eventManager);
        assertSame("HomeController should be a singleton", controller1, controller2);
    }

    // Test for Observer pattern.
    public static void testObserverPattern() {
        edu.ccu.students.logan.smarthome.observer.SmartHomeEventManager eventManager = new edu.ccu.students.logan.smarthome.observer.SmartHomeEventManager();
        TestObserver testObserver = new TestObserver();
        eventManager.subscribe(testObserver);
        eventManager.notify("test_event");
        assertTrue("TestObserver should be updated after notification", testObserver.isUpdated());
        testObserver.reset();
        eventManager.unsubscribe(testObserver);
        eventManager.notify("test_event");
        assertFalse("TestObserver should not be updated after unsubscription", testObserver.isUpdated());
    }

    // Test for Factory pattern.
    public static void testSmartDeviceFactory() {
        edu.ccu.students.logan.smarthome.core.SmartDevice device1 = edu.ccu.students.logan.smarthome.factory.SmartDeviceFactory.createDevice("smartlight", "Light1");
        edu.ccu.students.logan.smarthome.core.SmartDevice device2 = edu.ccu.students.logan.smarthome.factory.SmartDeviceFactory.createDevice("motionsensor", "Sensor1");

        assertTrue("Device1 should be an instance of SmartLight", device1 instanceof edu.ccu.students.logan.smarthome.devices.SmartLight);
        // Assuming a MotionSensor class exists in the devices package.
        assertTrue("Device2 should be an instance of MotionSensor", device2.getClass().getSimpleName().equals("MotionSensor"));
        assertEquals("Device1 name should be 'Light1'", "Light1", device1.getName());
        assertEquals("Device2 name should be 'Sensor1'", "Sensor1", device2.getName());
    }

    // Test for Builder pattern.
    public static void testRepositoryBuilder() {
        edu.ccu.students.logan.smarthome.core.SmartDevice light = edu.ccu.students.logan.smarthome.factory.SmartDeviceFactory.createDevice("smartlight", "Light1");
        edu.ccu.students.logan.smarthome.core.SmartDevice sensor = edu.ccu.students.logan.smarthome.factory.SmartDeviceFactory.createDevice("motionsensor", "Sensor1");

        edu.ccu.students.logan.smarthome.repository.SmartHomeRepository repo = new edu.ccu.students.logan.smarthome.repository.SmartHomeRepositoryBuilder()
                .addDevice(light)
                .addDevice(sensor)
                .build();

        assertEquals("Repository should contain two devices", 2, repo.getDevices().size());
        assertTrue("Repository should contain the light", repo.getDevices().contains(light));
        assertTrue("Repository should contain the sensor", repo.getDevices().contains(sensor));
    }

    // Test for Decorator pattern with SmartLightUsageTracker.
    public static void testSmartLightUsageTracker() throws InterruptedException {
        edu.ccu.students.logan.smarthome.devices.SmartLight light = new edu.ccu.students.logan.smarthome.devices.SmartLight("Tracked Light");
        edu.ccu.students.logan.smarthome.decorator.SmartLightUsageTracker tracker = new edu.ccu.students.logan.smarthome.decorator.SmartLightUsageTracker(light);

        tracker.turnOn();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            // Handle interruption if needed.
        }
        tracker.turnOff();

        long activeTime = tracker.getTotalActiveTime();
        assertTrue("Tracked active time should be at least 50ms", activeTime >= 50);
    }

    // Helper class for testing Observer pattern.
    public static class TestObserver implements edu.ccu.students.logan.smarthome.observer.SmartHomeObserver {
        private boolean updated = false;
        @Override
        public void update(String event) {
            updated = true;
        }
        public boolean isUpdated() {
            return updated;
        }
        public void reset() {
            updated = false;
        }
    }

    public static void main(String[] args) {
        try {
            testSingletonHomeController();
            System.out.println("testSingletonHomeController passed.");

            testObserverPattern();
            System.out.println("testObserverPattern passed.");

            testSmartDeviceFactory();
            System.out.println("testSmartDeviceFactory passed.");

            testRepositoryBuilder();
            System.out.println("testRepositoryBuilder passed.");

            testSmartLightUsageTracker();
            System.out.println("testSmartLightUsageTracker passed.");

            System.out.println("All tests passed.");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

# SmartHome
| Requirement                                           | Path in repo                                                                 |
| ----------------------------------------------------- | ---------------------------------------------------------------------------- |
| **Core interface** – `SmartDevice`                    | `src/edu/ccu/students/logan/smarthome/SmartDevice.java`                      |
| **Native device** – e.g. `SmartLight`                 | `src/edu/ccu/students/logan/smarthome/SmartLight.java`                       |
| **Third-party device** – e.g. `LegacyThermostat`      | `src/edu/ccu/students/logan/smarthome/thirdparty/LegacyThermostat.java`      |
| **Adapter** – wrap 3rd-party into `SmartDevice`       | `src/edu/ccu/students/logan/smarthome/adapters/ThermostatAdapter.java`       |
| **Reflection loader** – dynamic adapter instantiation | `src/edu/ccu/students/logan/smarthome/adapters/AdapterLoader.java`           |
| **Device manager** – add/remove/manage devices        | `src/edu/ccu/students/logan/smarthome/DeviceManager.java`                    |
| **Event system** – observer interface & publisher     | `src/edu/ccu/students/logan/smarthome/events/SmartHomeObserver.java`         |
|                                                       | `src/edu/ccu/students/logan/smarthome/events/DeviceEventPublisher.java`      |
| **CLI & GUI entry point** – switchable interface      | `src/edu/ccu/students/logan/smarthome/Main.java`                             |
| **Swing GUI** – the provided `ControlPanel`           | `src/edu/ccu/students/logan/smarthome/ui/ControlPanel.java`                  |
| **Unit tests** – verify devices & events              | `test/` (e.g. `MainTest.class`, `MainTest$TestObserver.class`) ([GitHub][1]) |
| **Docker container** – for non-GUI runs               | `Dockerfile` at project root ([GitHub][1])                                   |
| **Design docs / UML** (optional)                      | `design-smart-home/` ([GitHub][1])                                           |
| **README / metadata**                                 | `README.md`, `sources.txt`, `test-results.txt` at project root ([GitHub][1]) |

[1]: https://github.com/SimpleTreeDa/SmartHome "GitHub - SimpleTreeDa/SmartHome"

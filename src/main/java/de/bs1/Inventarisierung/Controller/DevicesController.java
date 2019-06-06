package de.bs1.Inventarisierung.Controller;

import de.bs1.Inventarisierung.Repos.DeviceRepository;
import de.bs1.Inventarisierung.model.Device;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DevicesController {

    @Autowired
    DeviceRepository deviceRepository;

    @GetMapping(name = "/devices")
    private Device getAllDevices() {
        Device device = new Device(1, "test", "test");
        List<Device> iterable = new ArrayList<>();
        iterable.add(device);
        return device;
    }

}

package de.bs1.Inventarisierung.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import de.bs1.Inventarisierung.Repos.DeviceRepository;
import de.bs1.Inventarisierung.Repos.LocationRepository;
import de.bs1.Inventarisierung.model.Device;
import de.bs1.Inventarisierung.model.Location;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class DevicesController {

    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    LocationRepository locationRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @ResponseBody
    @RequestMapping(value = "/api/devices", method = RequestMethod.GET)
    private ImmutableList<Device> getAllDevices() {
        List<Device> devices = ImmutableList.copyOf(deviceRepository.findAll());
        for (Device device: devices) {
            if (device.getLocation() == null) {
                device.setLocation(new Location());
            }
        }
        return ImmutableList.copyOf(deviceRepository.findAll());
    }

    @RequestMapping(value = "/api/devices/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Device> getDeviceByID(@PathVariable("id") Long id) {
        Optional<Device> device = deviceRepository.findById(id);
        if (device.isPresent() && device.get().getLocation() == null) {
            device.get().setLocation(new Location());
        }
        return device;
    }


    @RequestMapping(value = "/api/devices", method = RequestMethod.POST)
    private Device insertDevice(@RequestBody Device device) {
        locationRepository.save(device.getLocation());
        return deviceRepository.save(device);
    }
}

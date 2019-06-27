package de.bs1.Inventarisierung.Controller;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import de.bs1.Inventarisierung.Repos.DeviceRepository;
import de.bs1.Inventarisierung.model.Device;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class DevicesController {

    @Autowired
    DeviceRepository deviceRepository;

    @ResponseBody
    @RequestMapping(value = "/api/devices", method = RequestMethod.GET)
    private ImmutableList<Device> getAllDevices() {
       return ImmutableList.copyOf(deviceRepository.findAll());
    }

    @RequestMapping(value = "/api/devices/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Device> getDeviceByID(@PathVariable("id") Long id) {
        return deviceRepository.findById(id);
    }


    @RequestMapping(value = "/api/insertDevices", method = RequestMethod.POST)
    private boolean insertDevice() {

        return true;
    }

}

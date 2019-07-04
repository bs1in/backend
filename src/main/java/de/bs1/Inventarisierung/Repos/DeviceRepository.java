package de.bs1.Inventarisierung.Repos;

import de.bs1.Inventarisierung.model.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Long>{
}

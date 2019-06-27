package de.bs1.Inventarisierung.Repos;

import de.bs1.Inventarisierung.model.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface DeviceRepository extends CrudRepository<Device, Long>{



}

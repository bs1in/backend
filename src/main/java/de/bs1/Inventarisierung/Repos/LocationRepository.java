package de.bs1.Inventarisierung.Repos;

import de.bs1.Inventarisierung.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}

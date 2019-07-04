package de.bs1.Inventarisierung.Repos;

import de.bs1.Inventarisierung.model.Device;
import de.bs1.Inventarisierung.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long>{
}

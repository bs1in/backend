package de.bs1.Inventarisierung.Controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import de.bs1.Inventarisierung.Repos.DeviceRepository;
import de.bs1.Inventarisierung.Repos.TicketRepository;
import de.bs1.Inventarisierung.model.Device;
import de.bs1.Inventarisierung.model.Ticket;
import de.bs1.Inventarisierung.model.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TicketController {
    private final TicketRepository ticketRepository;
    private final DeviceRepository deviceRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public TicketController(TicketRepository ticketRepository, DeviceRepository deviceRepository) {
        this.ticketRepository = ticketRepository;
        this.deviceRepository = deviceRepository;
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @ResponseBody
    @RequestMapping(value = "/api/tickets", method = RequestMethod.GET)
    private List<TicketDTO> getAllTicket() {
        List<Ticket> tickets = ImmutableList.copyOf(ticketRepository.findAll());
        List<TicketDTO> dtos = new ArrayList<>();
        for (Ticket t : tickets) {
            dtos.add(new TicketDTO(t.getId(), t.getDevice().getId(), t.getDescription(), t.isDone()));
        }
        return dtos;
    }

    @RequestMapping(value = "/api/tickets/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TicketDTO getTicketByID(@PathVariable("id") Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            Ticket t = ticket.get();
            return new TicketDTO(t.getId(), t.getDevice().getId(), t.getDescription(), t.isDone());
        }
        return null;
    }

    @RequestMapping(value = "/api/tickets/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public TicketDTO updateTicketByID(@PathVariable("id") Long id, @RequestBody TicketDTO requestTicket) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        Optional<Device> device = deviceRepository.findById(requestTicket.getDevice());
        if (ticket.isPresent() && device.isPresent()) {
            Ticket t = new Ticket(device.get(), requestTicket.getDescription(), requestTicket.isDone());
            t = ticketRepository.save(t);
            return new TicketDTO(t.getId(), t.getDevice().getId(), t.getDescription(), t.isDone());
        }
        return null;
    }


    @RequestMapping(value = "/api/tickets", method = RequestMethod.POST)
    private TicketDTO insertTicket(@RequestBody TicketDTO requestTicket) {
        Optional<Device> device = deviceRepository.findById(requestTicket.getDevice());

        if (device.isPresent()) {
            Ticket ticket = new Ticket(device.get(), requestTicket.getDescription(), requestTicket.isDone());
            ticket = ticketRepository.save(ticket);
            requestTicket.setId(ticket.getId());
            return requestTicket;
        }
        return null;
        //        try {
            //Ticket ticket = null;
            //ticket = objectMapper.readValue(requestTicket, Ticket.class);
//            return ticketRepository.save(requestTicket);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
    }
}

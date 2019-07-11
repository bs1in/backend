package de.bs1.Inventarisierung.model;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @Column(name = "id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "default_gen")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Device device;

    @Column(name = "description")
    private String description;

    @Column(name = "done")
    private boolean done;

    public Ticket() {
    }

    public Ticket(Device device, String description, boolean done) {
        this.device = device;
        this.description = description;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

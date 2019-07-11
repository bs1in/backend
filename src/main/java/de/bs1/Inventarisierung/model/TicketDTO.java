package de.bs1.Inventarisierung.model;

public class TicketDTO {
    private long device;
    private long id;
    private String description;
    private boolean done;

    public TicketDTO() {
    }

    public TicketDTO(long id, long device, String description, boolean done) {
        this.device = device;
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public long getDevice() {
        return device;
    }

    public void setDevice(long device) {
        this.device = device;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

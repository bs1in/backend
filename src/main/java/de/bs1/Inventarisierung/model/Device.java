package de.bs1.Inventarisierung.model;

import javax.persistence.*;

@Entity
public class Device {
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Device(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}

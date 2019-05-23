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

}

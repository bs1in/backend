package de.bs1.Inventarisierung.model;

import org.w3c.dom.Attr;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Device {

    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    Set<Attribut> attributs;

    @ManyToOne
    Location location;

    public Device(long id, String name, String description, Set<Attribut> attributs, Location location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.attributs = attributs;
        this.location = location;
    }

    public Device() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Attribut> getAttributs() {
        return attributs;
    }

    public void setAttributs(Set<Attribut> attributs) {
        this.attributs = attributs;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

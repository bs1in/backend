package de.bs1.Inventarisierung.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class Device {

    @Id
    @Column(name = "id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "default_gen")
    private long id;

    @Column(name = "name", nullable = false)
    private String name = "";

    @Column(name = "description", nullable = false)
    private String description = "";

    /*@Column(name = "attributes", nullable = false)
    private Map<String, String> attributes = new HashMap<String, String>();*/

    @ManyToOne
    private Location location = new Location("Kein Ort", "");

    public Device(long id, String name, String description,  /*Map<String, String> attributes,*/ Location location) {
        this.id = id;
        this.name = name;
        this.description = description;
        /*this.attributes = attributes;*/
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

   /* public  Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes( Map<String, String> attributes) {
        this.attributes = attributes;
    }*/

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

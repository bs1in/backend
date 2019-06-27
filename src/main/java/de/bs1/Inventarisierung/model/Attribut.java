package de.bs1.Inventarisierung.model;

import javax.persistence.*;

@Entity
public class Attribut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "default_gen")
    private long id;

    @Column
    private String name;

    public Attribut(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Attribut() {
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
}

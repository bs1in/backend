package de.bs1.Inventarisierung.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "default_gen")
    private long id;
}

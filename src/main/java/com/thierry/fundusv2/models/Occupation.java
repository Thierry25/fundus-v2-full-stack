package com.thierry.fundusv2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "occupations")
public class Occupation {
    @Id
    @GeneratedValue
    private Integer id;

    private String occupationName;
    // private String description

    public Occupation(){}

    public Occupation(String occupationName) {
        this.occupationName = occupationName;
    }

    public Integer getId() {
        return id;
    }

    public String getOccupationName() {
        return occupationName;
    }
}

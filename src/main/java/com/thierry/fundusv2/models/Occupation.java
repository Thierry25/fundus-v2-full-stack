package com.thierry.fundusv2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "occupations")
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String occupationName;
    // private String description
    @ManyToMany(mappedBy="occupations")
    private List<Account> accounts;

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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}

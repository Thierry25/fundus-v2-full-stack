package com.thierry.fundusv2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "occupations")
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    // private String description
    @ManyToMany(mappedBy="occupations")
    private List<Account> accounts;

    public Occupation(){}

    public Occupation(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setName(String occupationName) {
        this.name = occupationName;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}

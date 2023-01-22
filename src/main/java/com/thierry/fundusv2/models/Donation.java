package com.thierry.fundusv2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private Account donor;
    @Column(nullable = true)
    private String identifier;

    @ManyToMany(mappedBy = "donations")
    private List<HelpRequest> requests;

    private String comment;

    public Donation(){}

    public String getIdentifier() {
        return identifier;
    }

    public String getComment() {
        return comment;
    }

    public Integer getId() {
        return id;
    }

    public Account getDonor() {
        return donor;
    }

    public void setDonor(Account donor) {
        this.donor = donor;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

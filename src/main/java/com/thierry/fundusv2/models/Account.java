package com.thierry.fundusv2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, max = 20, message = "Please enter at least 2 characters and less than 20 characters")
    @Column(nullable = false)
    private String firstName;

    @Size(min=2, max = 20, message = "Please enter at least 2 characters and less than 20 characters")
    @Column(nullable = false)
    private String lastName;

    @Email(message = "Email is invalid")
    @Column(unique=true, nullable = false)
    private String email;

    @Size(min=12, max=30, message = "Please enter at least 12 characters and less than 30 characters")
    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    @Size(min= 6, max= 24, message = "Please enter at least 6 characters and less than 24 characters")
    private String username;

    @ManyToMany
    @JoinTable(
            name="accounts_occupations",
            joinColumns = {@JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="OCCUPATION_ID", referencedColumnName = "ID")}
    )
    private List<Occupation> occupations;

    @OneToMany(mappedBy = "requestor")
    private List<HelpRequest> requests;

    @OneToMany(mappedBy = "donor")
    private List<Donation> donations;

    public Account(){}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public List<Occupation> getOccupations() {
        return occupations;
    }

    public List<HelpRequest> getRequests() {
        return requests;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public Integer getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setOccupations(List<Occupation> occupations) {
        this.occupations = occupations;
    }

    public void setRequests(List<HelpRequest> requests) {
        this.requests = requests;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }
}

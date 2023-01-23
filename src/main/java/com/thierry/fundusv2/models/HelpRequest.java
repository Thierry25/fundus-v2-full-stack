package com.thierry.fundusv2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "requests")
public class HelpRequest {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private Account requestor;

    @Size(min = 10, max=150 ,message = "Please enter a title between 10 and 150 characters")
    @Column(nullable = false)
    private String title;

    @Size(min = 15, max= 1440, message = "Please enter a description between 20 and 1440 characters")
    @Column(nullable = false)
    private String description;

    @Min(value=10, message = "The amount should be at least be 10 dollars")
    @Max(value=10_000, message = "The amount cannot be more than 10,000.00 dollars")
    private Integer amount;

    @Size(min= 5, message = "The location should at least contain 5 characters")
    @Column(nullable = false)
    private String location;

    @ManyToMany
    @JoinTable(name = "requests_donations",
    joinColumns = {@JoinColumn(name="REQUEST_ID", referencedColumnName = "ID")},
    inverseJoinColumns = {@JoinColumn(name="DONATION_ID", referencedColumnName = "ID")})
    private List<Donation> donations;

    private boolean isActive;


    public HelpRequest(){}

    public Account getRequestor() {
        return requestor;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }

    public boolean isActive() {
        return isActive;
    }

    public Integer getId() {
        return id;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setRequestor(Account requestor) {
        this.requestor = requestor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

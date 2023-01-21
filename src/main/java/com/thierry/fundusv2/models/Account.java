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

    @OneToMany
    private List<HelpRequest> requests;
}

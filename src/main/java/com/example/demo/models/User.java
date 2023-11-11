package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native")
    @Column(name = "user_id")
    private Long id;

    private String name, lastName, email;

    private long dni;

    @ManyToMany
    @JoinTable(
            name = "campaign_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "campaign_id"))
    Set<Campaign> campaigns;

    public User(){};
    public User(String name, String lastname, String email, long dni) {
        this.name = name;
        this.lastName = lastname;
        this.email = email;
        this.dni = dni;
    }

}

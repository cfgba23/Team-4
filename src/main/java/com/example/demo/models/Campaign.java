package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data
@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native")
    @Column(name = "campaign_id")
    private Long id;

    private String description, name;

    private Integer totalAmount, currentAmount;

    private boolean isActive;

    private String campaignType;

   @ManyToMany
   @JoinTable(
           name = "campaign_user",
           joinColumns = @JoinColumn(name = "campaign_id"),
           inverseJoinColumns = @JoinColumn(name = "user_id"))
   Set<User> users;

    public Campaign(){};

    public Campaign(String name, String description, Integer totalAmount, Integer currentAmount, String campaignType, boolean isActive){
        this.name = name;
        this.description = description;
        this.totalAmount = totalAmount;
        this.campaignType = campaignType;
        this.currentAmount = currentAmount;
        this.isActive = isActive;
    }

}

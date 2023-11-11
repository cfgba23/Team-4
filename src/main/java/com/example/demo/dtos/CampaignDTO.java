package com.example.demo.dtos;

import com.example.demo.models.Campaign;
import com.example.demo.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Getter
public class CampaignDTO {

    private String description, name;

    private Integer totalAmount;

    private String campaignType;

    public CampaignDTO(){}
    public CampaignDTO(Campaign campaign){
        this.name = campaign.getName();
        this.description = campaign.getDescription();
        this.totalAmount = campaign.getTotalAmount();
        this.campaignType = campaign.getCampaignType();
    }

}

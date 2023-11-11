package com.example.demo.service;


import com.example.demo.dtos.CampaignDTO;
import com.example.demo.models.Campaign;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CampaingService {

    List<Campaign> getActiveCampaigns();

    ResponseEntity<?> createCampaign(CampaignDTO campaignDTO);
}

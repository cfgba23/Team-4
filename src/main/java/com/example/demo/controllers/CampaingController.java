package com.example.demo.controllers;

import com.example.demo.dtos.CampaignDTO;
import com.example.demo.models.Campaign;
import com.example.demo.service.CampaingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CampaingController {

    @Autowired
    CampaingService campaingService;

    @GetMapping("/campaign/active")
    public List<Campaign> getActiveCampaigns(){

        return campaingService.getActiveCampaigns();
    }

    @PostMapping("/campaign/create")
    public ResponseEntity<?> createUser(@RequestBody CampaignDTO campaignDTO){
        return campaingService.createCampaign(campaignDTO);
    }
}

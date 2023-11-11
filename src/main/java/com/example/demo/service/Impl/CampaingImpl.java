package com.example.demo.service.Impl;

import com.example.demo.dtos.CampaignDTO;
import com.example.demo.models.Campaign;
import com.example.demo.repositories.CampaingRepository;
import com.example.demo.service.CampaingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaingImpl implements CampaingService {

    @Autowired
    CampaingRepository campaingRepository;

    @Override
    public List<Campaign> getActiveCampaigns(){

        List<Campaign> campaigns = campaingRepository.findAll();

        for (Campaign camp : campaigns){
            if (camp.isActive() == false){
                campaigns.remove(camp);
            }
        }

        return campaigns;

    }

    @Override
    public ResponseEntity<?> createCampaign(CampaignDTO campaignDTO){

        if (campaignDTO.getCampaignType() == null){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        if (campaignDTO.getName() == null){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        if (campaignDTO.getDescription() == null){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        if (campaignDTO.getTotalAmount() == null){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        Campaign campaign = new Campaign(
                campaignDTO.getName(),
                campaignDTO.getDescription(),
                campaignDTO.getTotalAmount(),
                0,
                campaignDTO.getCampaignType(),
                true
        );

        campaingRepository.save(campaign);

        return new ResponseEntity<>("Campaña creada correctamente", HttpStatus.OK);
    }

}

package com.example.demo.repositories;

import com.example.demo.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaingRepository extends JpaRepository<Campaign, Long> {
}

package com.steamlike.steamlike.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steamlike.steamlike.entity.concretes.Campaign;

@Repository
public interface CampaignDao extends JpaRepository<Campaign, Long> {

}

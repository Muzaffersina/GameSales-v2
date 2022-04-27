package com.steamlike.steamlike.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCampaign {

	private long id;

	private String campaignInfo;
	
	private int campaignAmount;

	private long gameId;

}

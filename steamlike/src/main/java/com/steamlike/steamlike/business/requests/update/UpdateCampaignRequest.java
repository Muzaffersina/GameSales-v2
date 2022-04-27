package com.steamlike.steamlike.business.requests.update;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCampaignRequest {
	@NotNull
	@Positive
	private long id;
	
	@NotNull
	@Size(min = 1)
	private String campaignInfo;

	@NotNull
	@Positive
	private int campaignAmount;
	@NotNull
	@Positive
	private long gameId;

}

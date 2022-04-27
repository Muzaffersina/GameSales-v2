package com.steamlike.steamlike.business.requests.create;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCampaignRequest {
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

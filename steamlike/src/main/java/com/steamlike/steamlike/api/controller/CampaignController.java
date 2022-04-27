package com.steamlike.steamlike.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.steamlike.steamlike.business.abstracts.CampaignService;
import com.steamlike.steamlike.business.dtos.ListCampaign;
import com.steamlike.steamlike.business.requests.create.CreateCampaignRequest;
import com.steamlike.steamlike.business.requests.delete.DeleteCampaignRequest;
import com.steamlike.steamlike.business.requests.update.UpdateCampaignRequest;
import com.steamlike.steamlike.core.results.DataResult;
import com.steamlike.steamlike.core.results.Result;

@RestController
@RequestMapping("/api/campaign-controller")
public class CampaignController {
	
	private CampaignService campaignService;

	@Autowired
	public CampaignController(CampaignService campaignService) {
		this.campaignService = campaignService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCampaignRequest createCampaignRequest) {
		
		return this.campaignService.add(createCampaignRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteCampaignRequest deleteCampaignRequest) {
		
		return this.campaignService.delete(deleteCampaignRequest);
	}
	@PutMapping	("/update")
	public Result update(@RequestBody @Valid UpdateCampaignRequest UpdateCampaignRequest) {
		
		return this.campaignService.update(UpdateCampaignRequest);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ListCampaign>> getAll(){ 
		return this.campaignService.getAll();
	}
}

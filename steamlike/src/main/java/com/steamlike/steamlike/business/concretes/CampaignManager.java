package com.steamlike.steamlike.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steamlike.steamlike.business.abstracts.CampaignService;
import com.steamlike.steamlike.business.abstracts.GameService;
import com.steamlike.steamlike.business.dtos.ListCampaign;
import com.steamlike.steamlike.business.requests.create.CreateCampaignRequest;
import com.steamlike.steamlike.business.requests.delete.DeleteCampaignRequest;
import com.steamlike.steamlike.business.requests.update.UpdateCampaignRequest;
import com.steamlike.steamlike.core.concretes.BusinessException;
import com.steamlike.steamlike.core.mapper.ModelMapperService;
import com.steamlike.steamlike.core.results.DataResult;
import com.steamlike.steamlike.core.results.Result;
import com.steamlike.steamlike.core.results.SuccessDataResult;
import com.steamlike.steamlike.core.results.SuccessResult;
import com.steamlike.steamlike.dataaccess.CampaignDao;
import com.steamlike.steamlike.entity.concretes.Campaign;

@Service
public class CampaignManager implements CampaignService {

	private ModelMapperService modelMapperService;
	private CampaignDao campaignDao;
	private GameService gameService;

	@Autowired
	public CampaignManager(ModelMapperService modelMapperService, CampaignDao campaignDao
			,GameService gameService) {

		this.modelMapperService = modelMapperService;
		this.campaignDao = campaignDao;
		this.gameService = gameService;
	}

	@Override
	public Result add(CreateCampaignRequest createCampaignRequest) {
		
		this.gameService.checkGameExists(createCampaignRequest.getGameId());
		Campaign campaign = this.modelMapperService.forRequest().map(createCampaignRequest, Campaign.class);

		this.campaignDao.save(campaign);

		return new SuccessResult("Campaign Saved");
	}

	@Override
	public Result delete(DeleteCampaignRequest deleteCampaignRequest) {
		
		checkCampaignExists(deleteCampaignRequest.getId());
		this.campaignDao.deleteById(deleteCampaignRequest.getId());
		return new SuccessResult("Campaign Deleted");
	}

	@Override
	public Result update(UpdateCampaignRequest updateCampaignRequest) {
		
		checkCampaignExists(updateCampaignRequest.getId());
		this.gameService.checkGameExists(updateCampaignRequest.getGameId());
		
		Campaign campaign  = this.modelMapperService.forRequest().map(updateCampaignRequest, Campaign.class);	
		this.campaignDao.save(campaign);
		return new SuccessResult("Campaign Updated");
	
	}

	@Override
	public DataResult<List<ListCampaign>> getAll() {
		
		List<Campaign> result = this.campaignDao.findAll();

		List<ListCampaign> response = result.stream()
				.map(campaign -> this.modelMapperService.forDto().map(campaign, ListCampaign.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListCampaign>>(response);
	}
	
	@Override
	public boolean checkCampaignExists(long id) {
		
		if(this.campaignDao.existsById(id)){
			return true;
		}
		throw new BusinessException("this campaign id doesnt exists");
	}
	

}

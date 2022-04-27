package com.steamlike.steamlike.business.abstracts;

import java.util.List;

import com.steamlike.steamlike.business.dtos.ListCampaign;
import com.steamlike.steamlike.business.requests.create.CreateCampaignRequest;
import com.steamlike.steamlike.business.requests.delete.DeleteCampaignRequest;
import com.steamlike.steamlike.business.requests.update.UpdateCampaignRequest;
import com.steamlike.steamlike.core.results.DataResult;
import com.steamlike.steamlike.core.results.Result;

public interface CampaignService {
	
	Result add(CreateCampaignRequest createCampaignRequest);
	Result delete(DeleteCampaignRequest deleteCampaignRequest);
	Result update(UpdateCampaignRequest updateCampaignRequest);
	
	DataResult<List<ListCampaign>> getAll();
	
	boolean checkCampaignExists(long id);

}

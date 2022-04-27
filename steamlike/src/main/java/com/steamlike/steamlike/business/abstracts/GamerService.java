package com.steamlike.steamlike.business.abstracts;

import java.util.List;

import com.steamlike.steamlike.business.dtos.ListGamer;
import com.steamlike.steamlike.business.requests.create.CreateGamerRequest;
import com.steamlike.steamlike.business.requests.delete.DeleteGamerRequest;
import com.steamlike.steamlike.business.requests.update.UpdateGamerRequest;
import com.steamlike.steamlike.core.results.DataResult;
import com.steamlike.steamlike.core.results.Result;

public interface GamerService {
	
	Result add(CreateGamerRequest createGamerRequest);
	Result update(UpdateGamerRequest updateGamerRequest);
	Result delete(DeleteGamerRequest deleteGamerRequest);
	
	DataResult<List<ListGamer>> getAll();
	DataResult<ListGamer> getById(long gamerId);
	boolean checkGamerExists(long gamerId);
}

package com.steamlike.steamlike.business.abstracts;

import java.util.List;

import com.steamlike.steamlike.business.dtos.ListGame;
import com.steamlike.steamlike.business.requests.create.CreateGameRequest;
import com.steamlike.steamlike.business.requests.delete.DeleteGameRequest;
import com.steamlike.steamlike.business.requests.update.UpdateGameRequest;
import com.steamlike.steamlike.core.results.DataResult;
import com.steamlike.steamlike.core.results.Result;

public interface GameService {
	Result add(CreateGameRequest createGameRequest);
	Result delete(DeleteGameRequest deleteGameRequest);
	Result update(UpdateGameRequest updateGameRequest);
	
	DataResult<List<ListGame>> getAll();
	
	boolean checkGameExists(long id);
	DataResult<ListGame> getByGameId(long gameID);
}

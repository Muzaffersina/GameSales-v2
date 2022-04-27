package com.steamlike.steamlike.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steamlike.steamlike.business.abstracts.GameService;
import com.steamlike.steamlike.business.dtos.ListGame;
import com.steamlike.steamlike.business.requests.create.CreateGameRequest;
import com.steamlike.steamlike.business.requests.delete.DeleteGameRequest;
import com.steamlike.steamlike.business.requests.update.UpdateGameRequest;
import com.steamlike.steamlike.core.concretes.BusinessException;
import com.steamlike.steamlike.core.mapper.ModelMapperService;
import com.steamlike.steamlike.core.results.DataResult;
import com.steamlike.steamlike.core.results.Result;
import com.steamlike.steamlike.core.results.SuccessDataResult;
import com.steamlike.steamlike.core.results.SuccessResult;
import com.steamlike.steamlike.dataaccess.GameDao;
import com.steamlike.steamlike.entity.concretes.Game;

@Service
public class GameManager implements GameService {

	private ModelMapperService modelMapperService;
	private GameDao gameDao;

	@Autowired
	public GameManager(ModelMapperService modelMapperService, GameDao gameDao) {
	
		this.modelMapperService = modelMapperService;
		this.gameDao = gameDao;
	}

	@Override
	public Result add(CreateGameRequest createGameRequest) {

		Game game = this.modelMapperService.forRequest().map(createGameRequest, Game.class);
		this.gameDao.save(game);

		return new SuccessResult("Game Saved");
	}

	@Override
	public Result delete(DeleteGameRequest deleteGameRequest) {

		checkGameExists(deleteGameRequest.getId());	
		this.gameDao.deleteById(deleteGameRequest.getId());
		return new SuccessResult("Game Deleted");

	}

	@Override
	public Result update(UpdateGameRequest updateGameRequest) {
		
		checkGameExists(updateGameRequest.getId());
		Game game = this.modelMapperService.forRequest().map(updateGameRequest, Game.class);
		this.gameDao.save(game);

		return new SuccessResult("Game Updated");
	}

	@Override
	public DataResult<List<ListGame>> getAll() {
		
		List<Game> result = this.gameDao.findAll();

		List<ListGame> response = result.stream()
				.map(game -> this.modelMapperService.forDto().map(game, ListGame.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListGame>>(response);
	}
	
	@Override
	public boolean checkGameExists(long id) {
		
		if(this.gameDao.existsById(id)) {
			return true;
		}
		throw new BusinessException("this game id doesnt exists");
	}

	@Override
	public DataResult<ListGame> getByGameId(long gameID) {
		
		checkGameExists(gameID);
		
		Game result = this.gameDao.getById(gameID);
		ListGame response = this.modelMapperService.forDto().map(result, ListGame.class);
		
		return new SuccessDataResult<ListGame>(response);
	}

}

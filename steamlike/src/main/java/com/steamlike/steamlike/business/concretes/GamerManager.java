package com.steamlike.steamlike.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steamlike.steamlike.business.abstracts.GamerService;
import com.steamlike.steamlike.business.dtos.ListGamer;
import com.steamlike.steamlike.business.requests.create.CreateGamerRequest;
import com.steamlike.steamlike.business.requests.delete.DeleteGamerRequest;
import com.steamlike.steamlike.business.requests.update.UpdateGamerRequest;
import com.steamlike.steamlike.core.concretes.BusinessException;
import com.steamlike.steamlike.core.mapper.ModelMapperService;
import com.steamlike.steamlike.core.mernis.abstracts.PersonCheckAdapterService;
import com.steamlike.steamlike.core.results.DataResult;
import com.steamlike.steamlike.core.results.Result;
import com.steamlike.steamlike.core.results.SuccessDataResult;
import com.steamlike.steamlike.core.results.SuccessResult;
import com.steamlike.steamlike.dataaccess.GamerDao;
import com.steamlike.steamlike.entity.concretes.Gamer;

@Service
public class GamerManager implements GamerService {

	private GamerDao gamerDao;
	private PersonCheckAdapterService personCheckAdapterService;
	private ModelMapperService modelMapperService;

	@Autowired
	public GamerManager(GamerDao gamerDao, PersonCheckAdapterService personCheckAdapterService,
			ModelMapperService modelMapperService) {

		this.gamerDao = gamerDao;
		this.personCheckAdapterService = personCheckAdapterService;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateGamerRequest createGamerRequest) {

		Gamer gamer = this.modelMapperService.forRequest().map(createGamerRequest, Gamer.class);
		
		checkIfRealPerson(gamer);
		this.gamerDao.save(gamer);

		return new SuccessResult("Gamer Saved");

	}

	@Override
	public Result update(UpdateGamerRequest updateGamerRequest) {

		checkGamerExists(updateGamerRequest.getGamerId());

		Gamer gamer = this.modelMapperService.forRequest().map(updateGamerRequest, Gamer.class);
		gamer.setSsn(toSet(updateGamerRequest.getGamerId()).getSsn());
		gamer.setDateOfBirth(toSet(updateGamerRequest.getGamerId()).getDateOfBirth());
		this.gamerDao.save(gamer);
		return new SuccessResult("Gamer Updated");
	}

	@Override
	public Result delete(DeleteGamerRequest deleteGamerRequest) {

		checkGamerExists(deleteGamerRequest.getGamerId());
		this.gamerDao.deleteById(deleteGamerRequest.getGamerId());
		return new SuccessResult("Gamer Deleted");
	}

	@Override
	public DataResult<List<ListGamer>> getAll() {

		List<Gamer> result = this.gamerDao.findAll();

		List<ListGamer> response = result.stream()
				.map(gamer -> this.modelMapperService.forDto().map(gamer, ListGamer.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListGamer>>(response);
	}

	@Override
	public DataResult<ListGamer> getById(long gamerId) {

		checkGamerExists(gamerId);
		Gamer result = this.gamerDao.getById(gamerId);
		ListGamer response = this.modelMapperService.forDto().map(result, ListGamer.class);

		return new SuccessDataResult<ListGamer>(response);
	}

	@Override
	public boolean checkGamerExists(long gamerId) {

		if (this.gamerDao.existsById(gamerId)) {
			return true;
		}
		throw new BusinessException("this gamer id doesnt exists");
	}

	private Gamer toSet(long gamerId) {
		Gamer gamer = this.gamerDao.getById(gamerId);
		return gamer;
	}

	private boolean checkIfRealPerson(Gamer gamer) {

		if (personCheckAdapterService.isPersonExist(gamer)) {
			return true;
		}
		throw new BusinessException("credential failed");
	}
}

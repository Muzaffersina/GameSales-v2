package com.steamlike.steamlike.business.concretes;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.steamlike.steamlike.business.abstracts.CampaignService;
import com.steamlike.steamlike.business.abstracts.GameService;
import com.steamlike.steamlike.business.abstracts.GamerService;
import com.steamlike.steamlike.business.abstracts.SaleService;
import com.steamlike.steamlike.business.dtos.ListSale;
import com.steamlike.steamlike.business.requests.create.CreateSaleRequest;
import com.steamlike.steamlike.business.requests.delete.DeleteSaleRequest;
import com.steamlike.steamlike.business.requests.update.UpdateSaleRequest;
import com.steamlike.steamlike.core.concretes.BusinessException;
import com.steamlike.steamlike.core.mapper.ModelMapperService;
import com.steamlike.steamlike.core.results.DataResult;
import com.steamlike.steamlike.core.results.Result;
import com.steamlike.steamlike.core.results.SuccessDataResult;
import com.steamlike.steamlike.core.results.SuccessResult;
import com.steamlike.steamlike.dataaccess.SaleDao;
import com.steamlike.steamlike.entity.concretes.Sale;

@Service
public class SaleManager implements SaleService {
	
	private ModelMapperService modelMapperService;
	private SaleDao saleDao;
	private GameService gameService;
	private GamerService gamerService;
	private CampaignService campaignService;

	public SaleManager(ModelMapperService modelMapperService, SaleDao saleDao
			,GameService gameService, GamerService gamerService
			,CampaignService campaignService) {
		this.modelMapperService = modelMapperService;
		this.saleDao = saleDao;
		this.gameService = gameService;
		this.gamerService = gamerService;
		this.campaignService = campaignService;
	}

	@Override
	public Result add(CreateSaleRequest createSaleRequest) {
		
		this.gamerService.checkGamerExists(createSaleRequest.getGamerGamerId());
		this.gameService.checkGameExists(createSaleRequest.getGameId());
		this.campaignService.checkCampaignExists(createSaleRequest.getCampaignId());
		
		Sale sale = this.modelMapperService.forRequest().map(createSaleRequest, Sale.class);
		sale.setPrice(calcAndReturnPrice(createSaleRequest.getGameId()));
		this.saleDao.save(sale);

		return new SuccessResult("Sale Saved");
	}

	@Override
	public Result delete(DeleteSaleRequest deleteSaleRequest) {

		checkSaleExists(deleteSaleRequest.getId());		
		this.saleDao.deleteById(deleteSaleRequest.getId());
		return new SuccessResult("Sale Deleted");
	}

	@Override
	public Result update(UpdateSaleRequest updateSaleRequest) {
		
		checkSaleExists(updateSaleRequest.getId());
		this.gamerService.checkGamerExists(updateSaleRequest.getGamerGamerId());
		this.gameService.checkGameExists(updateSaleRequest.getGameId());
		this.campaignService.checkCampaignExists(updateSaleRequest.getCampaignId());
		
		Sale sale = this.modelMapperService.forRequest().map(updateSaleRequest, Sale.class);
		sale.setPrice(calcAndReturnPrice(updateSaleRequest.getGameId()));
		this.saleDao.save(sale);

		return new SuccessResult("Sale Updated");
	}

	@Override
	public DataResult<List<ListSale>> getAll() {
		
		List<Sale> result = this.saleDao.findAll();

		List<ListSale> response = result.stream()
				.map(sale -> this.modelMapperService.forDto().map(sale, ListSale.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListSale>>(response);
	}
	
	private boolean checkSaleExists(long id) {
		
		if(this.saleDao.existsById(id)) {
			return true;
		}
		
		throw new BusinessException("this id doesnt exists");
	}
	
	private BigInteger calcAndReturnPrice(long gameId) {
		return this.gameService.getByGameId(gameId).getData().getPrice();
	}


}

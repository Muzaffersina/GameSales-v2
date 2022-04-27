package com.steamlike.steamlike.business.abstracts;

import java.util.List;

import com.steamlike.steamlike.business.dtos.ListSale;
import com.steamlike.steamlike.business.requests.create.CreateSaleRequest;
import com.steamlike.steamlike.business.requests.delete.DeleteSaleRequest;
import com.steamlike.steamlike.business.requests.update.UpdateSaleRequest;
import com.steamlike.steamlike.core.results.DataResult;
import com.steamlike.steamlike.core.results.Result;



public interface SaleService {
	
	Result add(CreateSaleRequest createSaleRequest);
	Result delete(DeleteSaleRequest deleteSaleRequest);
	Result update(UpdateSaleRequest updateSaleRequest);
	
	DataResult<List<ListSale>> getAll();

}

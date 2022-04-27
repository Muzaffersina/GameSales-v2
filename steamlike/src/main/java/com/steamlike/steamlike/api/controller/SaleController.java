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

import com.steamlike.steamlike.business.abstracts.SaleService;
import com.steamlike.steamlike.business.dtos.ListSale;
import com.steamlike.steamlike.business.requests.create.CreateSaleRequest;
import com.steamlike.steamlike.business.requests.delete.DeleteSaleRequest;
import com.steamlike.steamlike.business.requests.update.UpdateSaleRequest;
import com.steamlike.steamlike.core.results.DataResult;
import com.steamlike.steamlike.core.results.Result;

@RestController
@RequestMapping("/api/sale-controller")
public class SaleController {

	private SaleService saleService;
	
	@Autowired
	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateSaleRequest createSaleRequest) {
		
		return this.saleService.add(createSaleRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteSaleRequest deleteSaleRequest) {
		
		return this.saleService.delete(deleteSaleRequest);
	}
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateSaleRequest updateSaleRequest) {
		
		return this.saleService.update(updateSaleRequest);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ListSale>> getAll(){ 
		return this.saleService.getAll();
	}

}

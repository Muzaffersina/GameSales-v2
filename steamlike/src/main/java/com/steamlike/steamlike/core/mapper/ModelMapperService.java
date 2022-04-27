package com.steamlike.steamlike.core.mapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	

	ModelMapper forDto();
	ModelMapper forRequest();

}

package com.example.happyhouse.model.mapper;

import com.example.happyhouse.model.DealDto;

public interface DataMapper {
	public int addOfficeRentData(DealDto deal) throws Exception;

	public int addOfficeDealData(DealDto deal) throws Exception;

	public int addHomeRentData(DealDto deal) throws Exception;
	
	public int addHomeDealData(DealDto deal) throws Exception;
	
	public int addAptRentData(DealDto deal) throws Exception;
	
	public int addAptDealData(DealDto deal) throws Exception;
}

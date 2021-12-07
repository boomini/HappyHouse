package com.example.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.example.happyhouse.model.BicycleDto;
import com.example.happyhouse.model.BusDto;
import com.example.happyhouse.model.HomeInfoDto;
import com.example.happyhouse.model.HouseDealDto;
import com.example.happyhouse.model.HouseInfoDto;
import com.example.happyhouse.model.SidoGugunCodeDto;
import com.example.happyhouse.model.SubwayDto;

public interface HappyHouseMapService {
	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	//List<HouseInfoDto> getAptInDong(String dong) throws Exception;
	public List<HouseInfoDto> getAptInDong(Map<String, String> map) throws Exception;
	public List<HomeInfoDto> getHomeInDong(String dong) throws Exception;
//	List<HouseDealDto> getHouseDeal(String apt) throws Exception;
	List<BusDto> getBus(Map<String, String> map) throws Exception;
	List<SubwayDto> getSubway(Map<String, String> map) throws Exception;
	List<BicycleDto> getBicycle(Map<String, String> map) throws Exception;
	Map<String, String> gettranscnt(Map<String, String> map) throws Exception;
	
}

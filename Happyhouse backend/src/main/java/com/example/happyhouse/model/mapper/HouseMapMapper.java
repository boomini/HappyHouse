package com.example.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.example.happyhouse.model.BicycleDto;
import com.example.happyhouse.model.BusDto;
import com.example.happyhouse.model.HomeDealDto;
import com.example.happyhouse.model.HomeInfoDto;
import com.example.happyhouse.model.HomeRentDto;
import com.example.happyhouse.model.HouseDealDto;
import com.example.happyhouse.model.HouseInfoDto;
import com.example.happyhouse.model.SidoGugunCodeDto;
import com.example.happyhouse.model.SubwayDto;


public interface HouseMapMapper {
	List<SidoGugunCodeDto> getSido() throws SQLException;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws SQLException;
	List<HouseInfoDto> getDongInGugun(String gugun) throws SQLException;
	List<HouseInfoDto> getAptInDong(String dong) throws SQLException;
	List<HouseDealDto> getHouseDeal(String apt) throws Exception;
	List<HomeInfoDto> getHomeInDong(String dong) throws Exception;
	List<HomeDealDto> getHouseDealInHome(HomeInfoDto homeInfoDto) throws Exception;
	List<HomeRentDto> getHouseRentInHome(HomeInfoDto homeInfoDto) throws Exception;
	List<HomeDealDto> getAptDealInHome(HomeInfoDto homeInfoDto) throws Exception;
	List<HomeRentDto> getAptRentInHome(HomeInfoDto homeInfoDto) throws Exception;
	List<HomeDealDto> getOfficeDealInHome(HomeInfoDto homeInfoDto) throws Exception;
	List<HomeRentDto> getOfficeRentInHome(HomeInfoDto homeInfoDto) throws Exception;
	List<BusDto> getBus(Map<String, String> map) throws Exception;
	List<SubwayDto> getSubway(Map<String, String> map) throws Exception;
	List<BicycleDto> getBicycle(Map<String, String> map) throws Exception;
	String getbuscnt(Map<String, String> map) throws Exception;
	String getsubcnt(Map<String, String> map) throws Exception;
	String getbiccnt(Map<String, String> map) throws Exception;

}

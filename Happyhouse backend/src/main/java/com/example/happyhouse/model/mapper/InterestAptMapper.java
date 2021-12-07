package com.example.happyhouse.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.happyhouse.model.AptInterestDto;
import com.example.happyhouse.model.InterestValDto;

public interface InterestAptMapper {

	int insertInterest(AptInterestDto aptinterestdto) throws Exception;

	List<AptInterestDto> listInterest(String userid) throws Exception;

	void deleteInterest(Map<String, String> map) throws Exception;

	ArrayList<AptInterestDto> getInterestApt(InterestValDto interestvaldto) throws Exception;
}

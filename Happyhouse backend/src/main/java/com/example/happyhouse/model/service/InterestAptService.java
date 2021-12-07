package com.example.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.happyhouse.model.AptInterestDto;
import com.example.happyhouse.model.InterestValDto;

@Service
public interface InterestAptService {

	boolean registerinterest(AptInterestDto aptinterestdto) throws Exception;


	void removeReview(Map<String, String> map) throws Exception;

	List<AptInterestDto>resultInterest(InterestValDto interestvaldto) throws Exception;

}

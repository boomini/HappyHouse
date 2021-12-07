package com.example.happyhouse.model.service;

import java.util.List;

import com.example.happyhouse.model.HomeReviewDto;

public interface HomeReviewService {

	void modifyReview(HomeReviewDto homereviewdto) throws Exception;

	void removeReview(String reviewNo) throws Exception;

	List<HomeReviewDto> listReview(String aptNo) throws Exception;

	boolean registerReview(HomeReviewDto homereviewdto) throws Exception;

}

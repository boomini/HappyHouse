package com.example.happyhouse.model.mapper;

import java.util.List;

import com.example.happyhouse.model.HomeReviewDto;

public interface HomeReviewMapper {

	void updateReview(HomeReviewDto homereviewdto) throws Exception;

	List<HomeReviewDto> listReview(String home_code)  throws Exception;

	int insertReview(HomeReviewDto homereviewdto)  throws Exception;

	void deleteReview(String reviewNo)  throws Exception;

}

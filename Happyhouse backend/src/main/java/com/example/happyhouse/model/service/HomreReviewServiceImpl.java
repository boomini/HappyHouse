package com.example.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.happyhouse.model.HomeReviewDto;
import com.example.happyhouse.model.mapper.HomeReviewMapper;

@Service
public class HomreReviewServiceImpl implements HomeReviewService {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void modifyReview(HomeReviewDto homereviewdto) throws Exception {
		sqlSession.getMapper(HomeReviewMapper.class).updateReview(homereviewdto);
		
	}

	@Override
	public void removeReview(String reviewNo) throws Exception {
		HomeReviewMapper reviewMapper = sqlSession.getMapper(HomeReviewMapper.class);
		reviewMapper.deleteReview(reviewNo);		
	}

	@Override
	public List<HomeReviewDto> listReview(String aptNo) throws Exception {
		return sqlSession.getMapper(HomeReviewMapper.class).listReview(aptNo);
	}

	@Override
	public boolean registerReview(HomeReviewDto homereviewdto) throws Exception {
		return sqlSession.getMapper(HomeReviewMapper.class).insertReview(homereviewdto) == 1;
	}

}

package com.example.happyhouse.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.happyhouse.model.DealDto;
import com.example.happyhouse.model.mapper.DataMapper;

@Service
public class DataServiceImpl implements DataService {
	@Autowired
	private SqlSession sqlSession;
	
	/* 오피스텔 전월세 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addOfficeRentData(DealDto deal) throws Exception {
		return sqlSession.getMapper(DataMapper.class).addOfficeRentData(deal);
	}
	/* 오피스텔 매매 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addOfficeDealData(DealDto deal) throws Exception{
		return sqlSession.getMapper(DataMapper.class).addOfficeDealData(deal);
	}
	/* 연립다세대 전월세 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addHomeRentData(DealDto deal) throws Exception {
		return sqlSession.getMapper(DataMapper.class).addHomeRentData(deal);
	}
	
	/* 연립다세대 매매 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addHomeDealData(DealDto deal) throws Exception {
		return sqlSession.getMapper(DataMapper.class).addHomeDealData(deal);
	}
	
	/* 아파트 전월세 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addAptRentData(DealDto deal) throws Exception {
		return sqlSession.getMapper(DataMapper.class).addAptRentData(deal);
	}
	
	/* 아파트 매매 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addAptDealData(DealDto deal) throws Exception {
		return sqlSession.getMapper(DataMapper.class).addAptDealData(deal);
	}

}
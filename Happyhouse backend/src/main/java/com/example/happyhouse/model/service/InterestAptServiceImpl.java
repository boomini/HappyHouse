package com.example.happyhouse.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.happyhouse.model.AptInterestDto;
import com.example.happyhouse.model.InterestValDto;
import com.example.happyhouse.model.mapper.InterestAptMapper;
@Service
public class InterestAptServiceImpl implements InterestAptService {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean registerinterest(AptInterestDto aptinterestdto) throws Exception{
		return sqlSession.getMapper(InterestAptMapper.class).insertInterest(aptinterestdto) == 1;
	}


	@Override
	public void removeReview(Map<String, String> map) throws Exception{
		InterestAptMapper interestAptMapper = sqlSession.getMapper(InterestAptMapper.class);
		interestAptMapper.deleteInterest(map); 
		
	}

	@Override
	public List<AptInterestDto> resultInterest(InterestValDto interestvaldto) throws Exception{
		System.out.println(interestvaldto);
		ArrayList<AptInterestDto> interestApt=sqlSession.getMapper(InterestAptMapper.class).getInterestApt(interestvaldto);
		double cn = interestvaldto.getConvenientarr().length;
		double tn = interestvaldto.getTransarr().length;
		
		List<String> concate = Arrays.asList(interestvaldto.getConvenientarr());
		List<String> transate = Arrays.asList(interestvaldto.getTransarr());
		
		for(int i=0; i<interestApt.size(); i++) {
			AptInterestDto curdto = interestApt.get(i);
			double csum=0;
			double tsum=0;
			if(transate.contains("bus")) {
				tsum+=curdto.getBusScore();
			}
			if(transate.contains("subway")) {
				tsum+=curdto.getSubScore();	
			}
			if(transate.contains("bicycle")) {
				tsum+=curdto.getBicScore();
			}
			if(concate.contains("convenient")) {
				csum+=curdto.getConcScore();
			}
			if(concate.contains("kid")) {
				csum+=curdto.getKidScore();
			}
			if(concate.contains("school")) {
				csum+=curdto.getSchScore();
			}
			if(concate.contains("hospital")) {
				csum+=curdto.getHosScore();
			}
			if(concate.contains("cafe")) {
				csum+=curdto.getCafeScore();
			}
			curdto.setConvenientScore(Math.round((csum/cn)*100)/100.0);
			curdto.setTransScore(Math.round((tsum/tn)*100)/100.0);
			System.out.println(curdto);
			curdto.setTotalScore(Math.round(((curdto.getAreaScore()+curdto.getBuildScore()+curdto.getConvenientScore()+curdto.getTransScore())/4.0)*100)/100.0);
		}

		for(int i=0; i<interestApt.size(); i++) {
			System.out.println(interestApt.get(i).toString());
		}
		Collections.sort(interestApt);
		
		return interestApt;
	}

}

package com.example.happyhouse.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.happyhouse.model.MemberDto;
import com.example.happyhouse.model.mapper.MemberMapper;
import com.example.happyhouse.model.mapper.QnaMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if(memberDto.getIduser() == null || memberDto.getPassword() == null)
			return null;
		return sqlSession.getMapper(MemberMapper.class).login(memberDto);
	}
	
	@Override
	public MemberDto getMember(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).getMember(userid);
	}

	@Override
	public int idCheck(String checkId) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).idCheck(checkId);
	}

	@Override
	public void registerMember(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).registerMember(memberDto);

	}

	@Override
	public void registerInterest(Map<String, String> interest) throws Exception {
		sqlSession.getMapper(MemberMapper.class).registerInterest(interest);	
	}

	@Override
	public void deleteInterest(Map<String, String> interest) throws Exception {
		sqlSession.getMapper(MemberMapper.class).deleteInterest(interest);		
	}

	@Override
	public void updateMember(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).updateMember(memberDto);		
	}

	@Override
	@Transactional
	public void deleteMember(String userid) throws Exception {
		// 관심지역 삭제하기
		sqlSession.getMapper(MemberMapper.class).clearInterest(userid);
		
		// 쓴 답글, 질문 삭제하기
		sqlSession.getMapper(QnaMapper.class).clearAnswerById(userid);
		sqlSession.getMapper(QnaMapper.class).clearAnswerByQId(userid);
		sqlSession.getMapper(QnaMapper.class).clearQuestionById(userid);
		
		// 회원 삭제하기
		sqlSession.getMapper(MemberMapper.class).deleteMember(userid);		
	}

}

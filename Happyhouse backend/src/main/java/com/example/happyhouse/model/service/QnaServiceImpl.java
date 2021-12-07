package com.example.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.happyhouse.model.QnaAnswerDto;
import com.example.happyhouse.model.QnaDto;
import com.example.happyhouse.model.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<QnaDto> listQna() throws Exception {
		List<QnaDto> list = sqlSession.getMapper(QnaMapper.class).listQna();
		System.out.println("check qnadto" + list);
		for(int i=0;i<list.size(); i++) {
			System.out.println("check" + list.get(i));
			list.get(i).setQnaanswer(sqlSession.getMapper(QnaMapper.class).listAnswerQna(Integer.parseInt(list.get(i).getIdx())));
		}
		return list;
	}

	@Override
	public boolean writeQuestion(QnaDto qnaDto) throws Exception {
		if(qnaDto.getTitle() == null || qnaDto.getContent() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(QnaMapper.class).writeQuestion(qnaDto) ==1;
	}

	@Override
	public QnaDto getQna(int idx) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).getQna(idx);
	}

	@Override
	@Transactional
	public boolean modifyQna(QnaDto qnaDto) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).modifyQna(qnaDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteQna(int idx) throws Exception {
		List<QnaAnswerDto> list = sqlSession.getMapper(QnaMapper.class).listAnswerQna(idx);
		for(int i=0; i<list.size();i++) {
			if(sqlSession.getMapper(QnaMapper.class).deleteQnaAnswer(Integer.valueOf(list.get(i).getIdx()))!=1) throw new Exception();
		}
		return sqlSession.getMapper(QnaMapper.class).deleteQestion(idx) == 1;
	}

	@Override
	public boolean writeAnswer(QnaAnswerDto qnaAnswerDto) throws Exception {
		if(qnaAnswerDto.getTitle() == null || qnaAnswerDto.getContent() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(QnaMapper.class).writeQnaAnswer(qnaAnswerDto) ==1;
	}

	@Override
	public QnaAnswerDto getQnaAnswer(int idx) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).getQnaAnswer(idx);
	}

	@Override
	public boolean modifyQnaAnswer(QnaAnswerDto qnaAnswerDto) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).modifyQnaAnswer(qnaAnswerDto) == 1;
	}

	@Override
	public boolean deleteQnaAnswer(int idx) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).deleteQnaAnswer(idx) == 1;
	}
}

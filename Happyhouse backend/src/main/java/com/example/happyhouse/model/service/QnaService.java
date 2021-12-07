package com.example.happyhouse.model.service;

import java.util.List;

import com.example.happyhouse.model.QnaAnswerDto;
import com.example.happyhouse.model.QnaDto;

public interface QnaService {
	
	public List<QnaDto> listQna() throws Exception;
	
	//질문관련
	public boolean writeQuestion(QnaDto qnaDto) throws Exception;
	public QnaDto getQna(int idx) throws Exception;
	public boolean modifyQna(QnaDto qnaDto) throws Exception;
	public boolean deleteQna(int idx) throws Exception;
	
	//답변관련
	public boolean writeAnswer(QnaAnswerDto qnaAnswerDto) throws Exception;
	public QnaAnswerDto getQnaAnswer(int idx) throws Exception;
	public boolean modifyQnaAnswer(QnaAnswerDto qnaAnswerDto) throws Exception;
	public boolean deleteQnaAnswer(int idx) throws Exception;
}

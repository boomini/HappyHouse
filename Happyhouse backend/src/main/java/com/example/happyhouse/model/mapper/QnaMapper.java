package com.example.happyhouse.model.mapper;

import java.util.List;

import com.example.happyhouse.model.QnaAnswerDto;
import com.example.happyhouse.model.QnaDto;

public interface QnaMapper {

	//질문관련
	List<QnaDto> listQna() throws Exception;
	int writeQuestion(QnaDto qnaDto) throws Exception;
	QnaDto getQna(int idx) throws Exception;
	int modifyQna(QnaDto qnaDto) throws Exception;
	int deleteQestion(int idx) throws Exception;
	
	
	//답변관련
	List<QnaAnswerDto> listAnswerQna(int idx) throws Exception;
	int writeQnaAnswer(QnaAnswerDto qnaAnswerDto) throws Exception;
	QnaAnswerDto getQnaAnswer(int idx) throws Exception;
	int modifyQnaAnswer(QnaAnswerDto qnaAnswerDto) throws Exception;
	int deleteQnaAnswer(int idx) throws Exception;
	
	// 회원 탈퇴 시 관련
	int clearAnswerById(String iduser) throws Exception;
	int clearAnswerByQId(String iduser) throws Exception;
	int clearQuestionById(String iduser) throws Exception;
}

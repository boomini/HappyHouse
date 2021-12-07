package com.example.happyhouse.model.service;

import java.util.List;

import com.example.happyhouse.model.WordDto;


public interface WordService {

	List<WordDto> listWord();
	void registWord(List<String> concerns);
	void updateCount(String word);
	List<WordDto> interestlistWord();
	
}

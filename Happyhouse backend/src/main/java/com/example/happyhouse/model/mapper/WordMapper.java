package com.example.happyhouse.model.mapper;

import java.util.List;

import com.example.happyhouse.model.WordDto;

public interface WordMapper {

	List<WordDto> listWord();
	void updateCount(String word);
	List<WordDto> interestlistWord();
	
}

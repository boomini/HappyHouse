package com.example.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.happyhouse.model.WordDto;
import com.example.happyhouse.model.mapper.WordMapper;



@Service
public class WordServiceImpl implements WordService {

	@Autowired
	private WordMapper wordMapper;
	
	@Override
	public List<WordDto> listWord() {
	
		return wordMapper.listWord();
	}
	
	@Override
	public void registWord(List<String> concerns) {
		for(String concern : concerns) 
			wordMapper.updateCount(concern);
	}

	@Override
	public void updateCount(String word) {
		wordMapper.updateCount(word);
	}

	@Override
	public List<WordDto> interestlistWord() {
		return wordMapper.interestlistWord();
	}

}

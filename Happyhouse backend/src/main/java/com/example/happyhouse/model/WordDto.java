package com.example.happyhouse.model;

import io.swagger.annotations.ApiModelProperty;

public class WordDto {
	
	@ApiModelProperty(value = "관심단어")
	private String text;

	@ApiModelProperty(value = "관심단어 비중")
	private double size;



	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}

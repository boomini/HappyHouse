package com.example.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "HouseDealDto : 하우스거래정보", description = "집의 거래 상세 정보를 나타낸다.")
public class HouseDealDto {
	@ApiModelProperty(value = "거래 번호")
	int dealno;
	@ApiModelProperty(value = "아파트코드")
	int aptCode;	
	@ApiModelProperty(value = "거래금액")
	String dealAmount;
	@ApiModelProperty(value = "거래년도")
	int dealYear;
	@ApiModelProperty(value = "거래달")
	int dealMonth;
	@ApiModelProperty(value = "거래일")
	int dealDay;
	@ApiModelProperty(value = "전용면적")
	String area;
	@ApiModelProperty(value = "층")
	String floor;
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public int getDealno() {
		return dealno;
	}
	public void setDealno(int dealno) {
		this.dealno = dealno;
	}
	public int getAptCode() {
		return aptCode;
	}
	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public int getDealYear() {
		return dealYear;
	}
	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}
	public int getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}
	public int getDealDay() {
		return dealDay;
	}
	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}
	
}

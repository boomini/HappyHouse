package com.example.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "HomeRentDto : 매매전월세거래정보", description = "집의 거래 상세 정보를 나타낸다.")
public class HomeRentDto {
	@ApiModelProperty(value = "거래 번호")
	int dealno;
	@ApiModelProperty(value = "아파트코드")
	int aptCode;	
	@ApiModelProperty(value = "아파트이름")
	private String homeName;
	@ApiModelProperty(value = "보증금")
	String deposit;
	@ApiModelProperty(value = "월세")
	String rentMoney;
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
	@ApiModelProperty(value = "건축년도")
	int buildYear;
	
	
	public String getHomeName() {
		return homeName;
	}
	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
	public int getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getRentMoney() {
		return rentMoney;
	}
	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}
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
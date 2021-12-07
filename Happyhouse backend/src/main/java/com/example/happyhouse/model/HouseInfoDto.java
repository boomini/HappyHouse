package com.example.happyhouse.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "HouseInfoDto : 집정보", description = "집의 상세 정보를 나타낸다.")
public class HouseInfoDto {
	@ApiModelProperty(value = "아파트코드")
	private String aptCode;
	@ApiModelProperty(value = "아파트이름")
	private String aptName;
	@ApiModelProperty(value = "동코드")
	private String dongCode;
	@ApiModelProperty(value = "동이름")
	private String dongName;
	@ApiModelProperty(value = "시도이름")
	private String sidoName;
	@ApiModelProperty(value = "구군이름")
	private String gugunName;
	@ApiModelProperty(value = "건축년도")
	private int buildYear;
	@ApiModelProperty(value = "지번")
	private String jibun;
	@ApiModelProperty(value = "위도")
	private String lat;
	@ApiModelProperty(value = "경도")
	private String lng;
	@ApiModelProperty(value = "이미지")
	private String img;
	@ApiModelProperty(value = "최근거래금액")
	private String recentPrice;
	@ApiModelProperty(value = "평균금액")
	private String avgPrice;
	@ApiModelProperty(value = "도로명")
	private String roadName;
	@ApiModelProperty(value = "도로명건물본번호코드")
	private String buildingMajorCode;
	@ApiModelProperty(value = "도로명건물부번호코드")
	private String buildingMinorCode;
	@ApiModelProperty(value = "하우스딜 정보")
	private List<HouseDealDto> housedeal = new ArrayList<HouseDealDto>();
	
	
	public String getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(String avgPrice) {
		this.avgPrice = avgPrice;
	}
	public List<HouseDealDto> getHousedeal() {
		return housedeal;
	}
	public void setHousedeal(List<HouseDealDto> housedeal) {
		this.housedeal = housedeal;
	}
	public void addHousedeal(HouseDealDto housedeal) {
		this.housedeal.add(housedeal);
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getBuildingMajorCode() {
		return buildingMajorCode;
	}
	public void setBuildingMajorCode(String buildingMajorCode) {
		this.buildingMajorCode = buildingMajorCode;
	}
	public String getBuildingMinorCode() {
		return buildingMinorCode;
	}
	public void setBuildingMinorCode(String buildingMinorCode) {
		this.buildingMinorCode = buildingMinorCode;
	}
	public String getAptCode() {
		return aptCode;
	}
	public void setAptCode(String aptCode) {
		this.aptCode = aptCode;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	public int getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getRecentPrice() {
		return recentPrice;
	}
	public void setRecentPrice(String recentPrice) {
		this.recentPrice = recentPrice;
	}
	
	
}

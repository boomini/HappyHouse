package com.example.happyhouse.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "HomeInfoDto : 집정보", description = "집의 상세 정보를 나타낸다.")
public class HomeInfoDto {
	@ApiModelProperty(value = "아파트코드")
	private String homeCode;
	@ApiModelProperty(value = "아파트이름")
	private String homeName;
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
	@ApiModelProperty(value="type")
	private String type;
	@ApiModelProperty(value = "도로명건물본번호코드")
	private String buildingMajorCode;
	@ApiModelProperty(value = "도로명건물부번호코드")
	private String buildingMinorCode;
	@ApiModelProperty(value = "하우스딜 정보")
	private List<HomeDealDto> housedeal = new ArrayList<HomeDealDto>();
	@ApiModelProperty(value = "하우스 전/월세 정보")
	private List<HomeRentDto> houserent = new ArrayList<HomeRentDto>();
	
	
	public String getHomeCode() {
		return homeCode;
	}
	public void setHomeCode(String homeCode) {
		this.homeCode = homeCode;
	}
	public String getHomeName() {
		return homeName;
	}
	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(String avgPrice) {
		this.avgPrice = avgPrice;
	}
	public List<HomeDealDto> getHousedeal() {
		return housedeal;
	}
	public void setHousedeal(List<HomeDealDto> housedeal) {
		this.housedeal = housedeal;
	}
	public void addHousedeal(HomeDealDto housedeal) {
		this.housedeal.add(housedeal);
	}
	public List<HomeRentDto> getHouserent() {
		return houserent;
	}
	public void setHouserent(List<HomeRentDto> houserent) {
		this.houserent = houserent;
	}
	public void addHouserent(HomeRentDto houserent) {
		this.houserent.add(houserent);
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

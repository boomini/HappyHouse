package com.example.happyhouse.model;

public class AptInterestDto implements Comparable<AptInterestDto>{
	String idx;
	String home_code;
	String home_name;
	String iduser;
	String lat;
	String lng;;
	String buscnt;
	String biccnt;
	String subcnt;
	String cafecnt;
	String concnt;
	String kidcnt;
	String hoscnt;
	String schcnt;
	String build_year;
	String area;
	
	//각 항목 점수
	Double buildScore;
	Double areaScore;
	
	Double busScore;
	Double bicScore;
	Double subScore;
	
	Double cafeScore;
	Double concScore;
	Double kidScore;
	Double hosScore;
	Double schScore;
	
	//int priceScore;
	
	Double convenientScore;
	Double transScore;
	
	Double totalScore;
	
	public Double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}
	public Double getBuildScore() {
		return buildScore;
	}
	public void setBuildScore(Double buildScore) {
		this.buildScore = buildScore;
	}
	public Double getAreaScore() {
		return areaScore;
	}
	public void setAreaScore(Double areaScore) {
		this.areaScore = areaScore;
	}
	public Double getBusScore() {
		return busScore;
	}
	public void setBusScore(Double busScore) {
		this.busScore = busScore;
	}
	public Double getBicScore() {
		return bicScore;
	}
	public void setBicScore(Double bicScore) {
		this.bicScore = bicScore;
	}
	public Double getSubScore() {
		return subScore;
	}
	public void setSubScore(Double subScore) {
		this.subScore = subScore;
	}
	public Double getCafeScore() {
		return cafeScore;
	}
	public void setCafeScore(Double cafeScore) {
		this.cafeScore = cafeScore;
	}
	public Double getConcScore() {
		return concScore;
	}
	public void setConcScore(Double concScore) {
		this.concScore = concScore;
	}
	public Double getKidScore() {
		return kidScore;
	}
	public void setKidScore(Double kidScore) {
		this.kidScore = kidScore;
	}
	public Double getHosScore() {
		return hosScore;
	}
	public void setHosScore(Double hosScore) {
		this.hosScore = hosScore;
	}
	public Double getSchScore() {
		return schScore;
	}
	public void setSchScore(Double schScore) {
		this.schScore = schScore;
	}
	public Double getConvenientScore() {
		return convenientScore;
	}
	public void setConvenientScore(Double convenientScore) {
		this.convenientScore = convenientScore;
	}
	public Double getTransScore() {
		return transScore;
	}
	public void setTransScore(Double transScore) {
		this.transScore = transScore;
	}
	public String getBuild_year() {
		return build_year;
	}
	public void setBuild_year(String build_year) {
		this.build_year = build_year;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSubcnt() {
		return subcnt;
	}
	public void setSubcnt(String subcnt) {
		this.subcnt = subcnt;
	}
	public String getHome_name() {
		return home_name;
	}
	public void setHome_name(String home_name) {
		this.home_name = home_name;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getHome_code() {
		return home_code;
	}
	public void setHome_code(String home_code) {
		this.home_code = home_code;
	}
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
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
	public String getBuscnt() {
		return buscnt;
	}
	public void setBuscnt(String buscnt) {
		this.buscnt = buscnt;
	}
	public String getBiccnt() {
		return biccnt;
	}
	public void setBiccnt(String biccnt) {
		this.biccnt = biccnt;
	}
	public String getCafecnt() {
		return cafecnt;
	}
	public void setCafecnt(String cafecnt) {
		this.cafecnt = cafecnt;
	}
	public String getConcnt() {
		return concnt;
	}
	public void setConcnt(String concnt) {
		this.concnt = concnt;
	}
	public String getKidcnt() {
		return kidcnt;
	}
	public void setKidcnt(String kidcnt) {
		this.kidcnt = kidcnt;
	}
	public String getHoscnt() {
		return hoscnt;
	}
	public void setHoscnt(String hoscnt) {
		this.hoscnt = hoscnt;
	}
	public String getSchcnt() {
		return schcnt;
	}
	public void setSchcnt(String schcnt) {
		this.schcnt = schcnt;
	}
	
	@Override
	public String toString() {
		return "AptInterestDto [idx=" + idx + ", home_code=" + home_code + ", home_name=" + home_name + ", iduser="
				+ iduser + ", lat=" + lat + ", lng=" + lng + ", buscnt=" + buscnt + ", biccnt=" + biccnt + ", subcnt="
				+ subcnt + ", cafecnt=" + cafecnt + ", concnt=" + concnt + ", kidcnt=" + kidcnt + ", hoscnt=" + hoscnt
				+ ", schcnt=" + schcnt + ", build_year=" + build_year + ", area=" + area + ", buildScore=" + buildScore
				+ ", areaScore=" + areaScore + ", busScore=" + busScore + ", bicScore=" + bicScore + ", subScore="
				+ subScore + ", cafeScore=" + cafeScore + ", concScore=" + concScore + ", kidScore=" + kidScore
				+ ", hosScore=" + hosScore + ", schScore=" + schScore + ", convenientScore=" + convenientScore
				+ ", transScore=" + transScore + ", totalScore=" + totalScore + "]";
	}
	@Override
	public int compareTo(AptInterestDto o) {
		if(o.totalScore-this.totalScore>=0)return 1;
		else return -1;
	}
	
	
}

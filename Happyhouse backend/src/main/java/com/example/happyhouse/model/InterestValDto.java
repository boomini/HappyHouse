package com.example.happyhouse.model;

import java.util.ArrayList;
import java.util.Arrays;

public class InterestValDto {
	String iduser;
	String home_code;
	int priceval;
	int convenienteval;
	int transval;
	int areaval;
	int buildyearval;
	String convenientarr[];
	String transarr[];
	
	ArrayList<AptInterestDto> aptinterestarr = new ArrayList<AptInterestDto>();
	
	
	public int getPriceval() {
		return priceval;
	}
	public void setPriceval(int priceval) {
		this.priceval = priceval;
	}
	public int getConvenienteval() {
		return convenienteval;
	}
	public void setConvenienteval(int convenienteval) {
		this.convenienteval = convenienteval;
	}
	public int getTransval() {
		return transval;
	}
	public void setTransval(int transval) {
		this.transval = transval;
	}
	public int getAreaval() {
		return areaval;
	}
	public void setAreaval(int areaval) {
		this.areaval = areaval;
	}
	public int getBuildyearval() {
		return buildyearval;
	}
	public void setBuildyearval(int buildyearval) {
		this.buildyearval = buildyearval;
	}
	public ArrayList<AptInterestDto> getAptinterestarr() {
		return aptinterestarr;
	}
	public void setAptinterestarr(ArrayList<AptInterestDto> aptinterestarr) {
		this.aptinterestarr = aptinterestarr;
	}
	
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public String getHome_code() {
		return home_code;
	}
	public void setHome_code(String home_code) {
		this.home_code = home_code;
	}
	public String[] getConvenientarr() {
		return convenientarr;
	}
	public void setConvenientarr(String[] convenientarr) {
		this.convenientarr = convenientarr;
	}
	public String[] getTransarr() {
		return transarr;
	}
	public void setTransarr(String[] transsarr) {
		this.transarr = transsarr;
	}
	@Override
	public String toString() {
		return "InterestValDto [iduser=" + iduser + ", home_code=" + home_code + ", priceval=" + priceval
				+ ", convenienteval=" + convenienteval + ", transval=" + transval + ", areaval=" + areaval
				+ ", buildyearval=" + buildyearval + ", convenientarr=" + Arrays.toString(convenientarr)
				+ ", transsarr=" + Arrays.toString(transarr) + "]";
	}
	
}

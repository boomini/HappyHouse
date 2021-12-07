package com.example.happyhouse.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MemberDto : 회원정보", description = "회원의 상세 정보를 나타낸다.")
public class MemberDto {
	@ApiModelProperty(value = "유저아이디")
	private String iduser;
	@ApiModelProperty(value = "비밀번호")
	private String password;
	@ApiModelProperty(value = "이름")
	private String name;
	@ApiModelProperty(value = "주소")
	private String addr;
	@ApiModelProperty(value = "관심지역 동코드")
	private List<String> dongcode = new ArrayList<String>();
	@ApiModelProperty(value = "관심지역 동이름")
	private List<String> dongname = new ArrayList<String>();
	
	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void addDongcode(String dcd) {
	      this.dongcode.add(dcd);
	}
	public void addDongname(String dcd) {
	      this.dongname.add(dcd);
	}

	public List<String> getDongcode() {
		return dongcode;
	}

	public void setDongcode(List<String> dongcode) {
		this.dongcode = dongcode;
	}

	public List<String> getDongname() {
		return dongname;
	}

	public void setDongname(List<String> dongname) {
		this.dongname = dongname;
	}

	@Override
	public String toString() {
		return "MemberDto [iduser=" + iduser + ", password=" + password + ", name=" + name + ", addr=" + addr
				+ ", dongcode=" + dongcode + ", dongname=" + dongname + "]";
	}
	
	
}

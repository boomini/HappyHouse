package com.example.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QnaAnswerDto : 큐앤에이 답변 정보", description = "큐앤에이 답변의 상세 정보를 나타낸다.")
public class QnaAnswerDto {
	@ApiModelProperty(value = "글번호")
	private String idx;
	@ApiModelProperty(value = "작성자 아이디")
	private String iduser;
	@ApiModelProperty(value = "글제목")
	private String title;
	@ApiModelProperty(value = "글내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String regtime;
	@ApiModelProperty(value = "질문번호")
	private String gidx;
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getGidx() {
		return gidx;
	}
	public void setGidx(String gidx) {
		this.gidx = gidx;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


}

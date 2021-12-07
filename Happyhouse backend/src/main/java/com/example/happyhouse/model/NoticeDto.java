package com.example.happyhouse.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "NoticeDto : 게시글정보", description = "게시글의 상세 정보를 나타낸다.")
public class NoticeDto {
	@ApiModelProperty(value = "글번호")
	private String idx;
	@ApiModelProperty(value = "작성자 아이디")
	private String iduser;
	@ApiModelProperty(value = "글제목")
	private String title;
	@ApiModelProperty(value = "글내용")
	private String content;
	@ApiModelProperty(value = "글종류")
	private String category;
	@ApiModelProperty(value = "작성일")
	private String regitime;
	@ApiModelProperty(value = "파일정보")
	private List<FileInfoDto> fileInfos;

	public String getIdx() {
		return idx;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getRegitime() {
		return regitime;
	}

	public void setRegitime(String regitime) {
		this.regitime = regitime;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getIduser() {
		return iduser;
	}

	public void setUserid(String iduser) {
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

	public List<FileInfoDto> getFileInfos() {
		return fileInfos;
	}
	
	public void setFileInfos(List<FileInfoDto> fileInfos) {
		this.fileInfos = fileInfos;
	}
}

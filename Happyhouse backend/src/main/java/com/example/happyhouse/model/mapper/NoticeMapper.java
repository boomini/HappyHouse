package com.example.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import com.example.happyhouse.model.FileInfoDto;
import com.example.happyhouse.model.NoticeDto;

public interface NoticeMapper {

	// CRUD
	int insertNotice(NoticeDto noticeDto) throws Exception;

	List<NoticeDto> listNotice(/* Map<String, Object> map */) throws Exception;
	NoticeDto getNotice(int noticeNo) throws Exception;
	void updateNotice(NoticeDto noticeDto) throws Exception;
	void deleteNotice(int noticeNo) throws Exception;
	
	// 파일
	int insertFile(NoticeDto noticeDto) throws Exception;
	void deleteFile(int noticeNo) throws Exception;
	List<FileInfoDto> fileInfoList(int noticeNo) throws Exception;
	
	// 페이징 처리
	int getTotalCount(Map<String, String> map) throws Exception;
}

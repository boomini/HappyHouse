package com.example.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.example.happyhouse.model.NoticeDto;
import com.example.util.PageNavigation;

public interface NoticeService {

	// CRUD
	boolean registerNotice(NoticeDto noticeDto) throws Exception;

	List<NoticeDto> listNotice(/* Map<String, String> map */) throws Exception;

	// NoticeDto detailNotice(NoticeDto noticeDto) throws Exception;
	NoticeDto getNotice(int noticeNo) throws Exception;

	void modifyNotice(NoticeDto noticeDto) throws Exception;

	void removeNotice(int noticeNo/* , String path */) throws Exception;

	// 페이징 처리
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;

}

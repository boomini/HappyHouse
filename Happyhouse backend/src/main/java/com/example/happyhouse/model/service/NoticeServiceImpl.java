package com.example.happyhouse.model.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.happyhouse.model.FileInfoDto;
import com.example.happyhouse.model.NoticeDto;
import com.example.happyhouse.model.mapper.NoticeMapper;
import com.example.happyhouse.model.mapper.QnaMapper;
import com.example.util.PageNavigation;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private SqlSession sqlSession;

	// CRUD

	@Override
	@Transactional
	public boolean registerNotice(NoticeDto noticeDto) throws Exception {
//		NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
//		noticeMapper.insertNotice(noticeDto);
		if(noticeDto.getTitle() == null || noticeDto.getContent() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(NoticeMapper.class).insertNotice(noticeDto) == 1;
//				&& sqlSession.getMapper(NoticeMapper.class).insertFile(noticeDto) == 1;
		
//		List<FileInfoDto> fileInfos = noticeDto.getFileInfos();
//		if (fileInfos != null && !fileInfos.isEmpty()) {
//			noticeMapper.insertFile(noticeDto);
//		}
	}
	

	@Override
	public List<NoticeDto> listNotice(/* Map<String, String> map */) throws Exception {
//		Map<String, Object> param = new HashMap<String, Object>(); //

////		String key = map.get("key");
//		// if("userid".equals(key))
//		// key = "g.userid";
//		// param.put("key", key == null ? "" : key);
//		param.put("word", map.get("word") == null ? "" : map.get("word"));
//
//		int currentPage = Integer.parseInt(map.get("pg") == null ? "1" : map.get("pg"));
//		int sizePerPage = Integer.parseInt(map.get("spp"));
//		int start = (currentPage - 1) * sizePerPage;
//		param.put("start", start);
//		param.put("spp", sizePerPage);

//		return sqlSession.getMapper(NoticeMapper.class).listNotice(param);
		return sqlSession.getMapper(NoticeMapper.class).listNotice();
	}

	// @Override
	// public NoticeDto detailNotice(NoticeDto noticeDto) throws Exception {
	// return noticeDao.detailNotice(noticeDto);
	// }

	@Override
	public NoticeDto getNotice(int noticeNo) throws Exception {
		return sqlSession.getMapper(NoticeMapper.class).getNotice(noticeNo);
	}

	@Override
	public void modifyNotice(NoticeDto noticeDto) throws Exception {
		sqlSession.getMapper(NoticeMapper.class).updateNotice(noticeDto);

	}

	@Override
	@Transactional
	public void removeNotice(int noticeNo/* , String path */) throws Exception {
		NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
//		List<FileInfoDto> fileList = noticeMapper.fileInfoList(noticeNo);
//		noticeMapper.deleteFile(noticeNo);
		noticeMapper.deleteNotice(noticeNo);
//		for (FileInfoDto fileInfoDto : fileList) {
//			File file = new File(
//					path + File.separator + fileInfoDto.getSaveFolder() + File.separator + fileInfoDto.getSaveFile());
//			file.delete();
//		}
	}

	// 페이징 처리
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = 10;
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(NoticeMapper.class).getTotalCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

}

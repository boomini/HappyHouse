package com.example.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.happyhouse.model.NoticeDto;
import com.example.happyhouse.model.QnaDto;
import com.example.happyhouse.model.service.NoticeService;
import com.example.util.PageNavigation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/notice")
@Api("게시판 컨트롤러  API V1")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
//	@GetMapping("/list")
//	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
//		ModelAndView mav = new ModelAndView();
//		System.out.println("notice list check!!");
//		String spp = map.get("spp"); // size per page (페이지당 글갯수)
//		map.put("spp", spp != null ? spp : "10");
//		List<NoticeDto> list = noticeService.listNotice(map);
//		PageNavigation pageNavigation = noticeService.makePageNavigation(map);
//		mav.addObject("notices", list);
//		mav.addObject("navigation", pageNavigation);
////		mav.addObject("key", map.get("key"));
//		mav.addObject("word", map.get("word"));
//		mav.setViewName("notice/list");
//		return mav;
//	}
	
//	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다. ", response = NoticeDto.class)
//	@PostMapping
//	public ResponseEntity<List<NoticeDto>> registerNotice(@RequestBody NoticeDto noticeDto) throws Exception {
//		noticeService.registerNotice(noticeDto);
//		List<NoticeDto> list = noticeService.listNotice();
//		return new ResponseEntity<List<NoticeDto>>(list, HttpStatus.OK);
//	}
	
	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다. ", response = String.class)
	@PostMapping
	public ResponseEntity<String> registerNotice(@RequestBody NoticeDto noticeDto) throws Exception {
		if (noticeService.registerNotice(noticeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "게시판 글목록", notes = "새로운 게시글 목록을 확인한다. 성공시 list와 ok상태를 실패시 no_content정보를 얻는다.", response = NoticeDto.class)
	@GetMapping
	public ResponseEntity<List<NoticeDto>> noticeList() throws Exception {
		List<NoticeDto> list = noticeService.listNotice();
		if(list != null) {
	         return new ResponseEntity<List<NoticeDto>>(list, HttpStatus.OK);
	      }
	      else
	         return new ResponseEntity<List<NoticeDto>>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "게시판 글보기", notes = "해당 게시글 상세정보를 확인한다.성공시 notice객체와 ok상태를 실패시 no_content정보를 얻는다. ", response = NoticeDto.class)
	@GetMapping(value = "/{idx}")
	public ResponseEntity<NoticeDto> noticeDetail(@PathVariable("idx") int noticeNo) throws Exception {
		System.out.println("DETAIL" + noticeNo);
		NoticeDto noticeDto = noticeService.getNotice(noticeNo);
		if(noticeDto != null)
			return new ResponseEntity<NoticeDto>(noticeDto, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
//	@GetMapping("/detail")
//	public NoticeDto noticeDetail() throws Exception {
//		int noticeNo = sessionStorage.getItem("")
//		NoticeDto noticeDto =
//	}
	
	@ApiOperation(value = "게시판 글수정", notes = "해당 게시글 정보를 수정한다.", response = NoticeDto.class)
	@PutMapping
	public ResponseEntity<NoticeDto> modifyNotice(@RequestBody NoticeDto noticeDto) throws Exception {
		noticeService.modifyNotice(noticeDto);
		return new ResponseEntity<NoticeDto>(noticeDto, HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시판 글삭제", notes = "해당 게시글 삭제. ", response = List.class)
	@DeleteMapping("/{idx}")
	public ResponseEntity<List<NoticeDto>> removeNotice(@PathVariable("idx") int noticeNo) throws Exception {
		noticeService.removeNotice(noticeNo/* , path */);
		List<NoticeDto> list = noticeService.listNotice();
		return new ResponseEntity<List<NoticeDto>>(list, HttpStatus.OK);
	}
}

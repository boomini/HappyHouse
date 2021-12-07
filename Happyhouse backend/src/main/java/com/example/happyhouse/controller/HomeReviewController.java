package com.example.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.happyhouse.model.HomeReviewDto;
import com.example.happyhouse.model.NoticeDto;
import com.example.happyhouse.model.service.HomeReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/review")
@Api("회원관련  API V1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeReviewController {
	@Autowired
	private HomeReviewService homeReviewService;

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";


	@ApiOperation(value = "리뷰작성", notes = "리뷰 정보를 입력한다. ", response = HomeReviewDto.class)
	@PostMapping
	public ResponseEntity<String> registerReview(@RequestBody HomeReviewDto homereviewdto) throws Exception {
		if (homeReviewService.registerReview(homereviewdto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "리뷰목록", notes = "아파트 리뷰 목록을 확인한다. 성공시 list와 ok상태를 실패시 no_content정보를 얻는다.", response = NoticeDto.class)
	@GetMapping("/{homeno}")
	public ResponseEntity<List<HomeReviewDto>> ReviewList(@PathVariable("homeno") String homeno) throws Exception {
		System.out.println(homeno);
		List<HomeReviewDto> list = homeReviewService.listReview(homeno);
		System.out.println(list);
		if (list != null) {
			return new ResponseEntity<List<HomeReviewDto>>(list, HttpStatus.OK);
		} else
			return new ResponseEntity<List<HomeReviewDto>>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "리뷰 글수정", notes = "해당 게시글 정보를 수정한다.", response = NoticeDto.class)
	@PutMapping
	public ResponseEntity<HomeReviewDto> modifyReview(@RequestBody HomeReviewDto homereviewdto) throws Exception {
		homeReviewService.modifyReview(homereviewdto);
		return new ResponseEntity<HomeReviewDto>(homereviewdto, HttpStatus.OK);
	}

	@ApiOperation(value = "리뷰 글삭제", notes = "해당 게시글 삭제. ", response = List.class)
	@DeleteMapping("/{idx}")
	public ResponseEntity<String> removeReview(@PathVariable("idx") String reviewNo) throws Exception {
		homeReviewService.removeReview(reviewNo/* , path */);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}

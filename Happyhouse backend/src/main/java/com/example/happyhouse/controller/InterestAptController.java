package com.example.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.happyhouse.model.AptInterestDto;
import com.example.happyhouse.model.InterestValDto;
import com.example.happyhouse.model.service.InterestAptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/interestapt")
@Api("관심아파트등록  API V1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InterestAptController {
	@Autowired
	private InterestAptService interestAptService;

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";


	@ApiOperation(value = "관심아파트등록", notes = "관심아파트를 등록한다. ", response = AptInterestDto.class)
	@PostMapping
	public ResponseEntity<String> registerReview(@RequestBody AptInterestDto aptinterestdto) throws Exception {
		if (interestAptService.registerinterest(aptinterestdto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

//	@ApiOperation(value = "관심아파트 목록", notes = "관심아파트 목록을 확인한다..", response = AptInterestDto.class)
//	@PostMapping("/sort")
//	public ResponseEntity<List<AptInterestDto>> ReviewList(@PathVariable("userid") String userid) throws Exception {
//		List<AptInterestDto> list = interestAptService.listInterest(userid);
//		System.out.println(list);
//		if (list != null) {
//			return new ResponseEntity<List<AptInterestDto>>(list, HttpStatus.OK);
//		} else
//			return new ResponseEntity<List<AptInterestDto>>(HttpStatus.NO_CONTENT);
//	}

	@ApiOperation(value = "관심아파트 목록", notes = "관심아파트 목록을 확인한다..", response = AptInterestDto.class)
	@PostMapping("/sort")
	public ResponseEntity<List<AptInterestDto>> ReviewList(@RequestBody InterestValDto interestvaldto) throws Exception {
		return new ResponseEntity<List<AptInterestDto>>(interestAptService.resultInterest(interestvaldto),HttpStatus.OK);
	}
	@ApiOperation(value = "관심아파트 삭제", notes = "해당 관심아파트 삭제. ", response = List.class)
	@DeleteMapping("/{userid}/{homecode}")
	public ResponseEntity<String> removeReview(@PathVariable("userid") String userid,@PathVariable("homecode") String homecode) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userid",userid);
		map.put("homecode",homecode);
		interestAptService.removeReview(map);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
package com.example.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.happyhouse.model.QnaAnswerDto;
import com.example.happyhouse.model.QnaDto;
import com.example.happyhouse.model.service.QnaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/qna")
@Api("QNA 컨트롤러  API V1")
public class QnaController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private QnaService qnaService;
	
	@ApiOperation(value = "Qna 글목록", notes = "모든 QNA글의 정보를 반환한다.", response =QnaDto.class)
	@GetMapping
	public ResponseEntity<List<QnaDto>> listQna() throws Exception {
		return new ResponseEntity<List<QnaDto>>(qnaService.listQna(), HttpStatus.OK);
	}
	
	//질문
	@ApiOperation(value = "Qna 질문작성", notes = "Qna 질문을 작성한다.. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeQuestion(@RequestBody @ApiParam(value = "질문 정보.", required = true) QnaDto qnaDto) throws Exception {
		if (qnaService.writeQuestion(qnaDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "질문 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = QnaDto.class)
	@GetMapping("/{idx}")
	public ResponseEntity<QnaDto> getQuestion(@PathVariable("idx") @ApiParam(value = "얻어올 질문의 idx.", required = true) int idx) throws Exception {
		return new ResponseEntity<QnaDto>(qnaService.getQna(idx), HttpStatus.OK);
	}
	
	@ApiOperation(value = "질문 글수정", notes = "글번호에 해당하는 게시글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyQuestion(@RequestBody @ApiParam(value = "수정할 글정보.", required = true) QnaDto qnaDto) throws Exception {	
		if (qnaService.modifyQna(qnaDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "질문 글삭제", notes = "글번호에 해당하는 qna 질문 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{idx}")
	public ResponseEntity<String> deleteQuestion(@PathVariable("idx") @ApiParam(value = "삭제할 글의 글번호.", required = true) int idx) throws Exception {
		if (qnaService.deleteQna(idx)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	//답변
	@ApiOperation(value = "Qna 답변작성", notes = "해당 질문의 답변을 작성한다.. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/answer")
	public ResponseEntity<String> writeAnswer(@RequestBody @ApiParam(value = "답변 정보.", required = true) QnaAnswerDto qnaAnswerDto) throws Exception {
		if (qnaService.writeAnswer(qnaAnswerDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "답변 글보기", notes = "글번호에 해당하는 답변의 정보를 반환한다.", response = QnaDto.class)
	@GetMapping("/answer/{idx}")
	public ResponseEntity<QnaAnswerDto> getAnswer(@PathVariable("idx") @ApiParam(value = "얻어올 답변의 idx.", required = true) int idx) throws Exception {
		return new ResponseEntity<QnaAnswerDto>(qnaService.getQnaAnswer(idx), HttpStatus.OK);
	}
	
	@ApiOperation(value = "답변 글수정", notes = "글번호에 해당하는 게시글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/answer")
	public ResponseEntity<String> modifyAnswer(@RequestBody @ApiParam(value = "수정할 답변정보.", required = true) QnaAnswerDto qnaAnswerDto) throws Exception {	
		if (qnaService.modifyQnaAnswer(qnaAnswerDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "답변 글삭제", notes = "글번호에 해당하는 qna 답변 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/answer/{idx}")
	public ResponseEntity<String> deleteAnswer(@PathVariable("idx") @ApiParam(value = "삭제할 글의 글번호.", required = true) int idx) throws Exception {
		if (qnaService.deleteQnaAnswer(idx)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
		
}

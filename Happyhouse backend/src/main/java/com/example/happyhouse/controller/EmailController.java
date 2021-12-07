package com.example.happyhouse.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.happyhouse.model.service.EmailService;
import com.example.happyhouse.model.service.EmailServiceImpl;

@RestController
@RequestMapping("/service")
public class EmailController {
	@Autowired
	EmailService service;

	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

	@PostMapping("/mail")
	@ResponseBody
	public void emailConfirm(@RequestBody String userId) throws Exception {
		logger.info("post emailConfirm");

//			String userId = map.get("userEmail");
		System.out.println("전달 받은 이메일 : " + userId);
		service.sendSimpleMessage(userId);
	}

	@PostMapping("/verifyCode")
	@ResponseBody
	public int verifyCode(@RequestBody String code) {
		logger.info("Post verifyCode");

		int result = 0;
		code = code.substring(1, code.length() - 1);
		System.out.println("code : " + code);
		System.out.println("정답 code : " + EmailServiceImpl.ePw);
		System.out.println("code match : " + EmailServiceImpl.ePw.equals(code));
		if (EmailServiceImpl.ePw.equals(code)) {
			result = 1;
		}
		System.out.println("Result: " + result);
		return result;
	}
}
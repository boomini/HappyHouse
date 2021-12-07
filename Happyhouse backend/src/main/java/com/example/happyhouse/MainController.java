package com.example.happyhouse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

//	@GetMapping("/aptsearch")
//	public String aptsearch() {
//		System.out.println("aptsearch");
//		return "map/aptsearch";
//	}
//	
//	@GetMapping("/login")
//	public String login() {
//		System.out.println("login");
//		return "member/login";
//	}
//	
//	@GetMapping("/signup")
//	public String signup() {
//		System.out.println("signup");
//		return "member/sign_up";
//	}
//	
//	@GetMapping("/mypage")
//	public String mypage() {
//		System.out.println("member_info");
//		return "member/member_info";
//	}
//	
//	@GetMapping("/notice")
//	public String notice() {
//		System.out.println("notice");
//		return "notice";
//	}
//	
//	@GetMapping("/detail")
//	public String mvNoticeDetail() {
//		System.out.println("notice detail 페이지로 이동~");
//		return "notice/detail";
//	}
//	
//	@GetMapping("/register")
//	public String mvRegisterNotice() {
//		System.out.println("notice register 페이지로 이동~");
//		return "notice/register";
//	}
//	
//	@GetMapping("/modifyuser")
//	public String mvModifyUser() {
//		System.out.println("user update 페이지로 이동~");
//		return "member/member_update";
//	}

}

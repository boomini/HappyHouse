package com.example.happyhouse.model.service;

import java.util.Map;

import com.example.happyhouse.model.MemberDto;

public interface MemberService {

	MemberDto login(MemberDto memberDto) throws Exception;
	MemberDto getMember(String userid) throws Exception;

	int idCheck(String checkId) throws Exception;

	void registerMember(MemberDto memberDto) throws Exception;
	void updateMember(MemberDto memberDto) throws Exception;
	void deleteMember(String userid) throws Exception;
	void registerInterest(Map<String, String> interest) throws Exception;
	void deleteInterest(Map<String, String> interest) throws Exception;
}

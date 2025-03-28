package com.kh.spring.member.model.service;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.spring.exception.PasswordNotMatchException;
import com.kh.spring.member.model.dao.MemberMapper;
import com.kh.spring.member.model.dto.MemberDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final BCryptPasswordEncoder passwordEncoder;
	private final MemberValidator validator;
	private final MemberMapper memberMapper;
	
	@Override
	public MemberDTO login(MemberDTO member) {
		
		validator.validatedLoginMember(member);
		validator.validateMemberExists(member);
		MemberDTO loginMember = validator.validateMemberExists(member);
		if(passwordEncoder.matches(member.getMemberPw(), loginMember.getMemberPw())) {
			return loginMember;
		} else {
			throw new PasswordNotMatchException("비밀번호가 일치하지 않습니다.");
		}
		
	}

	@Override
	public void signUp(MemberDTO member) {

	}

	@Override
	public void update(MemberDTO member, HttpSession session) {

	}

	@Override
	public int delete(MemberDTO member) {
		return 0;
	}

	@Override
	public String idCheck(String memberId) {
		return null;
	}

}
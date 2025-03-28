package com.kh.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.dto.MemberDTO;
import com.kh.spring.member.model.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로거(logger) 객체 자동 생성
@Controller // Spring MVC에서 컨트롤러 클래스를 나타냄
@RequiredArgsConstructor // final 필드나 @NonNull이 붙은 필드에 대해 자동으로 생성자를 생성
public class MemberController {
	
	private final MemberService memberService;
	
	@PostMapping("login")
	public ModelAndView login(MemberDTO member, 
							  HttpSession session,
							  ModelAndView mv) {
		
		MemberDTO loginMember = memberService.login(member);
		
		if(loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			mv.setViewName("redirect:/");
		} else {
			mv.addObject("message", "로그인 실패")
			  .setViewName("include/error_page");
		}
		return mv;
	}
	
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session,
							   ModelAndView mv) {
		session.removeAttribute("loginMember");
		mv.setViewName("redirect:/");
		
		return mv;
	}
	
	@GetMapping("signup-form")
	public String signupForm() {
		
		return "member/signup-form";
	}
	
	@PostMapping("signup")
	public void join(MemberDTO member) {
		log.info("{}", member);
	}
	
}

package com.kh.spring.member.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor // 인자가 없는 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 인자로 받는 생성자 자동 생성
@ToString // 클래스의 필드 값 출력
public class MemberDTO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String email;
	private Date enrollDate;
}

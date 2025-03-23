package com.kh.spring.member.model.dao;

import org.apache.ibatis.annotations.Select;

import com.kh.spring.member.model.dto.MemberDTO;

public interface MemberMapper {
	
	@Select("SELECT\r\n"
			+ "				MEMBER_ID memberId\r\n"
			+ "			  , MEMBER_PW memberPw\r\n"
			+ "			  , MEMBER_NAME memberName\r\n"
			+ "			  , EMAIL\r\n"
			+ "			  , ENROLL_DATE enrollDate\r\n"
			+ "		  FROM\r\n"
			+ "		  		JAR_MEMBER\r\n"
			+ "		 WHERE\r\n"
			+ "		 		MEMBER_ID = #{ memberId }")
	MemberDTO login(MemberDTO member);
}

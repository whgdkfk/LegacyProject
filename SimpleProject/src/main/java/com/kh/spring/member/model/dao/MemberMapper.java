package com.kh.spring.member.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.spring.member.model.dto.MemberDTO;

@Mapper
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
	
	@Select("SELECT MEMBER_ID FROM KH_MEMBER WHERE MEMBER_ID = #{ memberId }")
	String idCheck(String memberId);
	
	@Insert("INSERT	\r\n"
			+ "		  INTO\r\n"
			+ "		  		JAR_MEMBER\r\n"
			+ "		VALUES\r\n"
			+ "			  (\r\n"
			+ "				#{ memberId }\r\n"
			+ "			  , #{ memberPw }\r\n"
			+ "			  , #{ memberName }\r\n"
			+ "			  , #{ email }\r\n"
			+ "			  , SYSDATE \r\n"
			+ "			  )")
	int signUp(MemberDTO member);
}

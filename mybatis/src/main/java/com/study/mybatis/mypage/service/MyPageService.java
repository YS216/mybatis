package com.study.mybatis.mypage.service;

import com.study.mybatis.member.service.MemberService;
import com.study.mybatis.member.vo.Member;

public interface MyPageService {
	int getMyPage(Member m);
	
	int updateMyPage(Member m);
}

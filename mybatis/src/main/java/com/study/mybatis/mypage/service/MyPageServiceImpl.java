package com.study.mybatis.mypage.service;

import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.common.Template;
import com.study.mybatis.member.vo.Member;
import com.study.mybatis.mypage.dao.MyPageDao;

public class MyPageServiceImpl implements MyPageService {
	private MyPageDao pDao = new MyPageDao(); 
	
	@Override
	public int getMyPage(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int getMember = pDao.getMyPage(sqlSession, m);
		
		sqlSession.close();
		
		return getMember;
	}

	@Override
	public int updateMyPage(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int updateMyPage = pDao.updateMyPage(sqlSession, m);
		
		if(updateMyPage > 0) { sqlSession.commit(); }
		
		sqlSession.close();
		
		return updateMyPage;
	}

}

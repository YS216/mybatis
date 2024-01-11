package com.study.mybatis.mypage.dao;

import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.member.vo.Member;

public class MyPageDao {
	public int getMyPage(SqlSession sqlSession, Member m) {
		return sqlSession.selectOne("mypageMapper.getMyPage", m);
	}
	
	public int updateMyPage(SqlSession sqlSession, Member m) {
		return sqlSession.update("mypageMapper.updateMyPage", m);
	}
}

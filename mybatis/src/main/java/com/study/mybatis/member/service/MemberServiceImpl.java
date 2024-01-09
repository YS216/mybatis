package com.study.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.common.Template;
import com.study.mybatis.member.dao.MemberDao;
import com.study.mybatis.member.vo.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao mDao = new MemberDao();
	
	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		Member loginUser = mDao.loginMember(sqlSession, m);
		sqlSession.close();
		return loginUser;
	}

	@Override
	public int checkId(String user_id) {
		SqlSession sqlSession = Template.getSqlSession();
		int checkid = mDao.checkId(sqlSession, user_id);
		sqlSession.close();
		return checkid;
	}
	
	@Override
	public int insertMember(Member m) {
		
		return 0;
	}



	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package com.study.mybatis.member.dao;

import java.sql.PreparedStatement;

import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.member.vo.Member;

public class MemberDao {
	// Member loginUser = mDao.loginMember(sqlSession, m);
	public Member loginMember(SqlSession sqlSession, Member m) {
		/* 기존의 방법
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select id from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			flag = rs.next();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
		*/
		
		
		/*
		 * sqlSession에서 제공하는 메소드를 통해 sql문을 찾아 실행하고 결과를 바로 받음
		    - 결과 : sqlSession.sql문 종류에 맞는 메소드("매퍼의 별칭.해당sql문고유한id",[이sql문을 완성시킬객체])
		 */
		
		/*
		Member me = sqlSession.selectOne("", m);
		return me;
		이 2줄을 아래와 같이 한줄로
		*/
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	
	public int checkId(SqlSession sqlSession, String user_id) {
		return sqlSession.selectOne("memberMapper.checkId", user_id);
	}
}













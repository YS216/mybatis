package com.study.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.board.dao.BoardDao;
import com.study.mybatis.board.vo.Board;
import com.study.mybatis.board.vo.Reply;
import com.study.mybatis.common.Template;
import com.study.mybatis.common.vo.PageInfo;

public class BoardServiceImpl implements BoardService {
	private BoardDao bDao = new BoardDao();
	
	// 총 게시글의 수
	@Override
	public int selectTotalRecord() {
		SqlSession sqlSession = Template.getSqlSession();
		int totalRecord = bDao.selectTotalRecord(sqlSession);
		sqlSession.close();
		return totalRecord;
	}
	
	// 총 게시글 목록
	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		sqlSession.close();
		return list;
	}

	// 검색어를 넣은 게시글의 총 수
	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = bDao.selectSearchCount(sqlSession, map);
		sqlSession.close();
		return searchCount;
	}

	// 검색어를 넣은 게시글 리스트 목록
	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectSearchList(sqlSession, map, pi);
		sqlSession.close();
		return list;
	}
	
	// 조회수 증가
	@Override
	public int increaseCount(int board_no) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = bDao.increaseCount(sqlSession, board_no);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}

	// 게시글 상세보기(1개 조회)
	@Override
	public Board selectBoard(int board_no) {
		SqlSession sqlSession = Template.getSqlSession();
		Board b = bDao.selectBoard(sqlSession, board_no);
		sqlSession.close();
		return b;
	}

	// 1개의 게시글의 댓글 리스트 목록 
	@Override
	public ArrayList<Reply> selectReplyList(int board_no) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Reply> list = bDao.selectReplyList(sqlSession, board_no);
		sqlSession.close();
		return list;
	}

	@Override
	public int insertReply(Reply reply) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = bDao.insertReply(sqlSession, reply);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}


}

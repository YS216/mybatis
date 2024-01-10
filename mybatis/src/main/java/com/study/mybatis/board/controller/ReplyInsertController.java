package com.study.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.study.mybatis.board.service.BoardServiceImpl;
import com.study.mybatis.board.vo.Board;
import com.study.mybatis.board.vo.Reply;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int board_no = Integer.parseInt(request.getParameter("bnum"));
		
		Reply reply = new Reply();
		reply.setRef_bno(board_no);
		reply.setReply_content(request.getParameter("content"));
		reply.setReply_writer(request.getParameter("userId"));
		
		int result = new BoardServiceImpl().insertReply(reply);
		
		if(result > 0) {
			// board_no에 해당하는 댓글 리스트 조회
			ArrayList<Reply> list = new BoardServiceImpl().selectReplyList(board_no);
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("WEB-INF/views/board/boardDetailView.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "댓글 등록 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}

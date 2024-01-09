package com.study.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.study.mybatis.board.service.BoardService;
import com.study.mybatis.board.service.BoardServiceImpl;
import com.study.mybatis.board.vo.Board;
import com.study.mybatis.common.Pagination;
import com.study.mybatis.common.vo.PageInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("keyField", keyField);
		map.put("keyWord", keyWord);
		
		BoardService bService = new BoardServiceImpl();
		
		int searchCount = bService.selectSearchCount(map);
		
		PageInfo pi = Pagination.getPageInfo(searchCount, nowPage, 5, 3);
		
		ArrayList<Board> list = bService.selectSearchList(map, pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.setAttribute("keyField", keyField);
		request.setAttribute("keyWord", keyWord);
		
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
	}
}

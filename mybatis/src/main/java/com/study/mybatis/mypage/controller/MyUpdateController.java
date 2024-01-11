package com.study.mybatis.mypage.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.study.mybatis.member.vo.Member;
import com.study.mybatis.mypage.service.MyPageServiceImpl;

public class MyUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m = new Member();
		
		m.setUser_id(request.getParameter("user_id"));
		m.setUser_pwd(request.getParameter("user_pwd"));
		m.setUser_name(request.getParameter("user_name"));
		m.setEmail(request.getParameter("email"));
		m.setBirthday(request.getParameter("birthday"));
		m.setGender(request.getParameter("gender"));
		m.setPhone(request.getParameter("phone"));
		m.setAddress(request.getParameter("address"));	
		
		int result = new MyPageServiceImpl().updateMyPage(m);
		
		if(result == 1) {
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("errorMsg", "마이페이지 수정 실패");
			
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}

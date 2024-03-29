package com.study.mybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.study.mybatis.member.service.MemberServiceImpl;
import com.study.mybatis.member.vo.Member;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Member m = new Member();
		m.setUser_id(request.getParameter("userId"));
		m.setUser_pwd(request.getParameter("userPwd"));
		m.setEmail(request.getParameter("userEmail"));
		m.setPhone(request.getParameter("userPhone"));
		m.setAddress(request.getParameter("userAddress"));
		
		Member loginUser = new MemberServiceImpl().loginMember(m);
		
		if(loginUser == null) {	// 로그인 실패
			request.setAttribute("errorMsg", "로그인 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath());
			// getContextPath() : root path
		}
	}

}

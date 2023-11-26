package com.z3un.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.z3un.dao.MemberDao;
import com.z3un.dto.MemberDto;

/**
 * 로그인하기
 */
@WebServlet("/login/loginProcess")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet() 요청");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("post방식으로 요청해주세요.");
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDao memberDao = new MemberDao();
		
		//로그인
		MemberDto memberDto = memberDao.login(id, pw);
		

		
		memberDao.close();
		if(memberDto != null) {
			System.out.println(id +"/"+pw);
			session.setAttribute("id", id);
			session.setAttribute("dto", memberDto);
			response.sendRedirect("/board/boardList");
			
		} else {
			System.out.println("로그인 실패");
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

}

package com.z3un.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z3un.dao.BoardDao;
import com.z3un.dto.BoardDto;
import com.z3un.dto.Criteria;
import com.z3un.dto.PageDto;


@WebServlet("/board/boardList")
public class BoardMainCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("보트컨트롤러");
		String pageNo = request.getParameter("pageNo");
		String amount = request.getParameter("amount");
		BoardDao boardDao = new BoardDao();
		
		
		//페이지네이션
		Criteria cri = new Criteria(pageNo, amount);
		PageDto pageDto = new PageDto(cri, boardDao.getTotalCnt(cri));
		request.setAttribute("pageDto", pageDto);
		//리스트 출력
		List<BoardDto> list = boardDao.getBoardList(cri);
		request.setAttribute("list", list);
		
		
		
		boardDao.close();
		request.getRequestDispatcher("/board/boardMain.jsp").forward(request, response);
		
	}


}

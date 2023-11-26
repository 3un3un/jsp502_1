package com.z3un.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.z3un.common.DBConnPool;
import com.z3un.dto.BoardDto;
import com.z3un.dto.Criteria;

public class BoardDao extends DBConnPool{

	public BoardDao() {
		// TODO Auto-generated constructor stub
	}
	public List<BoardDto> getBoardList(Criteria cri){
		List<BoardDto> list = new ArrayList<>();
		String where="";
//		if(!"".equals(cri.getSearchField()) && !"".equals(cri.getSearchWord())) {
//			where="where "+cri.getSearchField()
//				+" like '%"+cri.getSearchWord()+"%'";
//		}
		String sql = "select *\r\n"
				+ "    from board\r\n"
				+where
				+ "    order by num desc";
		try {
			sql = pageingQuery(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cri.getStartNo());
			pstmt.setInt(2, cri.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				String num = rs.getString("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				String postdate = rs.getString("postdate");
				String visitcount = rs.getString("visitcount");
				BoardDto dto = new BoardDto(num, title, content, id, postdate, visitcount);
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
		
	}
	
	
	public int getTotalCnt(Criteria cri){
		String sql = "select count(*) from board";
		int tot = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			tot = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tot;
		
		
	}

}

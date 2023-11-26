package com.z3un.dao;

import java.sql.SQLException;

import com.z3un.common.DBConnPool;
import com.z3un.dto.MemberDto;

public class MemberDao extends DBConnPool{


	public MemberDao() {
	}
	
	public MemberDto login(String userId, String pass) {
		MemberDto dto = null;
		try {
			String sql = "select * from member\r\n"
					+ "where id=?\r\n"
					+ "and pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pass");
				dto = new MemberDto(id, pw);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	

}

package com.z3un;

import java.sql.SQLException;

import com.z3un.common.DBConnection;


public class MakeTestBoard extends DBConnection{

	public int insert() {
		int res = 0;
		String sql = "insert into board (num, title, content, id, postdate, visitcount)\r\n"
				+ "values (seq_board_num.nextval,"
				+ " '제목'||seq_board_num.currval||'입니다',"
				+ " '내용'||seq_board_num.currval||'입니다',"
				+ " 'test',"
				+ " sysdate, 0)";
		try {
			pstmt = con.prepareStatement(sql);

			//입력 실행
			res = pstmt.executeUpdate();
			System.out.println(res+"건 입력되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 자바프로그램 실행
	 * 
	 */
	public static void main(String[] args) {
		MakeTestBoard b = new MakeTestBoard();
		for(int i=0; i<170; i++) {
			b.insert();
		}
		//자원 반납
		b.close();
	}

}

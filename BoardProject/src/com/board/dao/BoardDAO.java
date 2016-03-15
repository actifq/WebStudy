package com.board.dao;

import java.sql.*;
import java.util.*;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@211.238.142.81:1521:ORCL";
	
	// 1. jdbc 드라이버 등록
	public BoardDAO(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	// 2. 연결객체 얻기
	public void getConnection(){
		try{
			conn=DriverManager.getConnection(URL,"scott","tiger");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	// 3. 연결해제
	public void disConnection(){
		try{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	// 4. 기능
	//  1) 목록 출력 ==> SELECT
	
	public List<BoardDTO> boardListData(int page){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try{
			getConnection();
			String sql="SELECT no,subject,name,regdate,hit,group_tab "
					     +"FROM BOARD ORDER BY group_id DESC,group_step ASC";
					     					     
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			int i=0;
			int j=0;  // while 문 돌아가는 횟수
			int pagecnt=(page*10)-10;
			while(rs.next()){
				if(i<10 && j>=pagecnt){
					BoardDTO d=new BoardDTO();
					d.setNo(rs.getInt(1));
					d.setSubject(rs.getString(2));
					d.setName(rs.getString(3));
					d.setRegdate(rs.getDate(4));
					d.setHit(rs.getInt(5));
					d.setGroup_tab(rs.getInt(6));
					list.add(d);
					i++;
				}
				j++;
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			disConnection();
		}
		return list;
	}
	
	//  2) 내용 보기 ==> SELECT ~ WHERE
	//  3) 추가 ==> INSERT
	//  4) 수정 ==> UPDATE
	//  5) 답변 ==> INSERT
	//  6) 삭제 ==> DELETE
	//  7) 찾기 ==> LIKE ~
	//  8) 총 페이지 구하기 ==> CEIL(COUNT(*)/10)
}













































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
	
	// 3. 연결객체
	public void disConnection(){
		try{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	// 4. 기능
	//  1) 목록 ==> SELECT
	
	public List<BoardDTO> boardListData(int page){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try{
			getConnection();
			String sql="SELECT no,subject,name,regdate,hit,group_tab "
					     +"FROM BOARD ORDER BY group_id DESC,group_step ASC";
					     					     
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			int i=0;
			int j=0;  
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
	
	//  2) 내용보기 ==> SELECT ~ WHERE
	public BoardDTO boardContentData(int no){
		BoardDTO d=new BoardDTO();
		
		try{
			getConnection();
			String sql="UPDATE board SET "
						   +"hit=hit+1 "
						   + "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
			ps.close();
			
			//데이터 읽어오기 
			sql="SELECT no,name,subject,content,regdate,hit "
				+ "FROM board "
				+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			d.setNo(rs.getInt(1));
			d.setName(rs.getString(2));
			d.setSubject(rs.getString(3));
			d.setContent(rs.getString(4));
			d.setRegdate(rs.getDate(5));
			d.setHit(rs.getInt(6));
			rs.close();
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			disConnection();
		}
		
		return d;
	}
	
	//  3) 추가==> INSERT
	public void boardInsert(BoardDTO d){
		try{
        	getConnection();
        	String sql="INSERT INTO board(no,name,subject,content,pwd,group_id) "
        			  +"VALUES((SELECT NVL(MAX(no)+1,1) FROM board),"
        			  +"?,?,?,?,"
        			  +"(SELECT NVL(MAX(group_id)+1,1) FROM board))";
			ps=conn.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getSubject());
			ps.setString(3, d.getContent());
			ps.setString(4, d.getPwd());
			//실행요청
			ps.executeUpdate();
							
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			disConnection();
		}
	}
	
	//  4) 수정 ==> UPDATE
	public void boardUpdate(BoardDTO d){
		try{
			getConnection();
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());

		}finally{
			disConnection();
		}
	}
	//  5) 답변 ==> INSERT
	//  6) 삭제 ==> DELETE
	//  7) 찾기 ==> LIKE ~
	
	
	//  8) 총 페이지 구하기 ==> CEIL(COUNT(*)/10)
	public int boardTotal(){
		int total=0;
		try{
			
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/10) FROM board";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			disConnection();
		}
		return total;
	}
	
	public int boardCount(){
		int total=0;
		try{
			
			getConnection();
			String sql="SELECT COUNT(*) FROM board";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			disConnection();
		}
		return total;
	}
	
}







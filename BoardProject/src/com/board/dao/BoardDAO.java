package com.board.dao;

import java.sql.*;
import java.util.*;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@211.238.142.81:1521:ORCL";
	
	// 1. jdbc ����̹� ���
	public BoardDAO(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	// 2. ���ᰴü ���
	public void getConnection(){
		try{
			conn=DriverManager.getConnection(URL,"scott","tiger");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	// 3. ��������
	public void disConnection(){
		try{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	// 4. ���
	//  1) ��� ��� ==> SELECT
	
	public List<BoardDTO> boardListData(int page){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try{
			getConnection();
			String sql="SELECT no,subject,name,regdate,hit,group_tab "
					     +"FROM BOARD ORDER BY group_id DESC,group_step ASC";
					     					     
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			int i=0;
			int j=0;  // while �� ���ư��� Ƚ��
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
	
	//  2) ���� ���� ==> SELECT ~ WHERE
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
			
			//������ �б� (��ȸ�� ������Ű�� ������ ��ȸ�� �о��)
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
	
	//  3) �߰� ==> INSERT
	//  4) ���� ==> UPDATE
	//  5) �亯 ==> INSERT
	//  6) ���� ==> DELETE
	//  7) ã�� ==> LIKE ~
	
	
	//  8) �� ������ ���ϱ� ==> CEIL(COUNT(*)/10)
	
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
	
/*	INSERT INTO board(no,name,subject,content,pwd,group_id,group_step,group_tab,root,depth)
	VALUES((SELECT NVL(MAX(no)+1,1) FROM board),'ȫ�浿','�亯���Խ��� ����','������ �����..','1234',
	32,1,1,32,1);
*/
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
			//�����û
			ps.executeUpdate();
							
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			disConnection();
		}
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













































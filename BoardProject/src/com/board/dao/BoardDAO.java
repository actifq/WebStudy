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
        			  +"(SELECT NVL(MAX(group_id)+"
        			  + ""
        			  + ""
        			  + "1,1) FROM board))";
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
	public void boardReply(int root,BoardDTO d){
		
		// => gi,gs,gt,root ==> gi,gs+1,gt+1, root
		// =>  insert

		/*										gi				gs				gt
		 *  AAAAAA						2				0				0
		 *  	=> BBBBBB				2				1				1
		 *  	=> DDDDDD				2				1				1	
		 *  		=> CCCCCC			2 				2				2
		 * 	
		 *
		 *										gi				gs				gt
		 *  AAAAAA						2				0				0
		 *  	=> DDDDDD				2				1				1
		 *  	=> BBBBBB				2				1				1
		 *  		=> CCCCCC			2 				2				2
		 *  UPDATE boart SET
		 *  group_step=group_step+1
		 *  WHERE group_id=1 AND group_step>0
		 */
		
		// => root ==> depth 증가
		
		
		
		try{
			getConnection();
			
			// JSP(예약), MVC(멀티미디어), Spring(ERP)
			// ERP => 빅데이터

			//group_tab (왼쪽에서 얼만큼 뗄껀지 결정함 
			String sql="SELECT group_id,group_step,group_tab "
					+ "FROM board "
					+ "WHERE no=?";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, root);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			int gi=rs.getInt(1);
			int gs=rs.getInt(2);
			int gt=rs.getInt(3);
			rs.close();
			ps.close();
			
			//답변형핵심 ! 답변끼리 꼬이지 않게 주는 쿼리 문장
			sql="UPDATE board SET " 
					+"group_step=group_step+1 "
					+ "WHERE group_id=? "
					+ "AND group_step>? ";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, gi);
			ps.setInt(2, gs);
			ps.executeUpdate();
			ps.close();
			
			sql="UPDATE board SET "
					+ "depth=depth+1 "
					+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, root);
			ps.executeUpdate();
			ps.close();
			
			sql="INSERT INTO board(no,name,subject,content,pwd,group_id,group_step,group_tab,root) "
       			  +"VALUES((SELECT NVL(MAX(no)+1,1) FROM board),"
       			  +"?,?,?,?,"
       			  +"?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getSubject());
			ps.setString(3, d.getContent());
			ps.setString(4, d.getPwd());
			ps.setInt(5, gi);
			ps.setInt(6, gs+1);
			ps.setInt(7, gt+1);
			ps.setInt(8, root);

			ps.executeUpdate();
			
		}catch(Exception ex){
			
		}finally{
			disConnection();
		}
		
	}
	
	//  6) 삭제 ==> DELETE
	public boolean boardDelete(int no,String pwd){
		boolean bCheck=false;
		
		try{
			getConnection();
			
			//pwd 체크
			
			String sql="SELECT pwd FROM board "
					+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			ps.close();
			
			if(db_pwd.equals(pwd)){
				bCheck=true;
				sql="SELECT root,depth FROM board "
					+ "WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1,no);
				rs=ps.executeQuery();
				rs.next();
				int root=rs.getInt(1);
				int depth=rs.getInt(2);
				rs.close();
				ps.close();
				if(depth==0){
					
					//DELETE
					sql="DELETE FROM board "
						+ "WHERE no=?";
					ps=conn.prepareStatement(sql);
					ps.setInt(1, no);
					ps.executeUpdate();
					ps.close();
				}else{
					//UPDATE
					sql="UPDATE board SET "
						+ "subject=?,content=? "
						+ "WHERE no=?";
					String msg="관리자가 삭제한 게시물 입니다.";
					ps=conn.prepareStatement(sql);
					ps.setString(1, msg);
					ps.setString(2, msg);
					ps.setInt(3, no);
					ps.executeUpdate();
					ps.close();
							
					
				}
				//depth 감소
				sql="UPDATE board SET "
					+ "depth=depth-1 "
					+ "WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, root);
				ps.executeUpdate();
			}else{
				bCheck=false;
			}
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			disConnection();
		}
		
		return bCheck;
	}
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







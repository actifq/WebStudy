package com.board.dao;
import java.util.*;
import javax.sql.*;
import javax.naming.*;
import java.sql.*;
public class BoardDAO {
	   private Connection conn;
	   private PreparedStatement ps;
	   public void getConnection()
	   {
		   try
		   {
			   Context init=new InitialContext();
			   Context c=(Context)init.lookup("java://comp/env");
			   DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			   conn=ds.getConnection();
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
		   }
	   }
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex){}
	   }
	   public List<BoardDTO> boardAllData(int page)
	   {
		   List<BoardDTO> list=
				   new ArrayList<BoardDTO>();
		   try
		   {
			   getConnection();
			   int rowSize=10;
			   int start=(page*rowSize)-(rowSize-1);
			   int end=page*rowSize;
			   // inline-view
			   String sql="SELECT no,subject,name,regdate,hit,num "
					     +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
					     +"FROM (SELECT no,subject,name,regdate,hit "
					     +"FROM databoard ORDER BY no DESC)) "
					     +"WHERE num BETWEEN "+start+" AND "+end;
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   BoardDTO d=new BoardDTO();
				   d.setNo(rs.getInt(1));
				   d.setSubject(rs.getString(2));
				   d.setName(rs.getString(3));
				   d.setRegdate(rs.getDate(4));
				   d.setHit(rs.getInt(5));
				   list.add(d);
			   }
			   rs.close();
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
		   }
		   finally
		   {
			   disConnection();
		   }
		   return list;
	   }
}








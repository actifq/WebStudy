package com.member.dao;
//C:\webDev\webStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPMiniProject\image

import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.io.*;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	public void getConnection(){
		try{
			Context init=new InitialContext();
			Context c=(Context)init.lookup("java://comp/env");
			DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			
			conn=ds.getConnection();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void disConnection(){
		try{
			if(ps!=null) ps.close();
			if(conn!=null)ps.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void saveFile(){
		try{
			getConnection();
			String sql="SELECT name,logcount "
							+ "FROM member";
			String data="name,count\n";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				data+=rs.getString(1)+"," 
						+rs.getInt(2)+"\n";
			}
			rs.close();
			String path="C:\\webDev\\webStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\JSPMiniProject\\image\\log.csv";
			File file=new File(path);
			if(!file.exists())
				file.createNewFile();
			
			FileWriter fw=new FileWriter(file);
			fw.write(data);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally {
			disConnection();
		}
	}
	
	public String isLogin(String id,String pwd){
		String result="";
	
		try{
			getConnection();
			
			String sql="SELECT COUNT(*) FROM member "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			ps.close();
			if(count==0){
				result="NOID";
			}
			else{
				sql="SELECT pwd,name FROM member "
						+ "WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String db_name=rs.getString(2);
				rs.close();
				ps.close();
				
				if(db_pwd.equals(pwd)){
					result=db_name;
					sql="UPDATE member SET "
							+ "logcount=logcount+1 "
							+ "WHERE id=?";
					ps=conn.prepareStatement(sql);
					ps.setString(1, id);
					ps.executeUpdate();
				}else{
					result="NOPWD";
				}
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			disConnection();
		}
		
		return result;
	}
	
}





































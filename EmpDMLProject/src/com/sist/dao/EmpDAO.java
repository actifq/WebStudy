package com.sist.dao;
import java.util.*;
import java.sql.*;
public class EmpDAO {
	// 연결 객체 얻기
		 private Connection conn;
		 // 문장 전송 객체 
		 private PreparedStatement ps;
		 // URL
		 private final String URL="jdbc:oracle:thin:@211.238.142.81:1521:ORCL";
		 // DRIVER 
		 private final String DRIVER="oracle.jdbc.driver.OracleDriver";
		 // USER NAME
		 private final String USER="scott";
		 // PWD
		 private final String PWD="tiger";
		 // 드라이버 등록 
		 public EmpDAO()
		 {
			 try
			 {
				 Class.forName(DRIVER);
			 }catch(Exception ex)
			 {
				 System.out.println(ex.getMessage());
			 }
		 }
		 // 연결 객체 얻기
		 public void getConnection()
		 {
			 try
			 {
				 conn=DriverManager.getConnection(URL,USER,PWD);
				 // conn scott/tiger
			 }catch(Exception ex){}
		 }
		 // 연결 해제
		 public void disConnection()
		 {
			 try
			 {
				 if(ps!=null) ps.close();
				 if(conn!=null) conn.close();
			 }catch(Exception ex){}
		 }
		 // 기능 
		 
		 public List<EmpDTO> empAllData(int page)
		 {
			 List<EmpDTO> list=
					 new ArrayList<EmpDTO>();
			 try
			 {
				 getConnection();
				 int rowSize=5;
				 int start=(rowSize*page)-(rowSize-1);
				 int end=rowSize*page;
				 // rownum BETWEEN start AND end
				 //                  1       5
				 //                  6       10
				 String sql="SELECT empno,ename,job,hiredate,deptno,num "
						   +"FROM (SELECT empno,ename,job,hiredate,deptno,rownum as num "
						   +"FROM (SELECT empno,ename,job,hiredate,deptno "
						   +"FROM emp ORDER BY empno DESC)) "
						   +"WHERE num BETWEEN "+start+" AND "+end;
				 ps=conn.prepareStatement(sql);
				 ResultSet rs=ps.executeQuery();
				 while(rs.next())
				 {
					 EmpDTO d=new EmpDTO();
					 d.setEmpno(rs.getInt(1));
					 d.setEname(rs.getString(2));
					 d.setJob(rs.getString(3));
					 d.setHiredate(rs.getDate(4));
					 d.setDeptno(rs.getInt(5));
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
		 
		 public int empTotalPage()
		 {
			 int total=0;
			 try
			 {
				 getConnection();
				 String sql="SELECT CEIL(COUNT(*)/5) FROM emp";
				 ps=conn.prepareStatement(sql);
				 ResultSet rs=ps.executeQuery();
				 rs.next();
				 total=rs.getInt(1);
				 rs.close();
			 }catch(Exception ex)
			 {
				 System.out.println(ex.getMessage());
			 }
			 finally
			 {
				 disConnection();
			 }
			 return total;
		 }
}







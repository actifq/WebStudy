/*

package com.sist.dao;
import java.sql.*;

 *   Connection : 오라클 연결 ==> Socket
 *   PreparedStatement : SQL 문장 전송 , 결과값을 읽어온다 ==> Reader,Writer
 *   ResultSet : 결과값 저장 => 메모리
 *   
 *   1) 드라이버 등록
 *      Class.forName("드라이버 클래스명")    ojdbc6.jar(반드시 존재해야함 => 오라클과 application을 연결해주는 역할 => thin driver)
 *      =============
 *         메모리 할당 (리플렉션) : 클래스정보를 읽어서 메모리 할당, 메소드 호출, 멤버변수 제어 
 *         new 사용 x (결합성이 강한 프로그램을 만들면 안됨) => new 대신에 Class.forName 사용
 *      => 오라클과 연결 준비
 *   2) 오라클 연결 객체를 얻어온다
 *      Connection => getConnection(URL,USERNAME,PWD)
 *   3) SQL문장 전송
 *      Statement
 *        = executeQuery : SELECT (결과 값 받아올때)
 *        = executeUpdate : INSERT,UPDATE,DELETE (자체적으로 갱신할 때)
 *   4) 결과값 받기
 *      ResultSet
 *      SELECT ename,job,hiredate
 *      ======================================
 *         ename        job         hiredate
 *      ======================================
 *                  BOF(Begin Of File)
 *      ======================================
 *          aaa         aaa           aaa      => next (bof -> eof)   
 *          bbb         bbb           bbb
 *          ccc         ccc           ccc      => previous (eof -> bof)
 *      ======================================
 *                  EOF(End Of File)
 *      ======================================
 *   5) 종료
 *      ResultSet => close
 *      Statement => close
 *      Connection => close
 *   
 
import java.util.*; //ArrayList
public class EmpDAO {
   // 연결 객체 얻기
   private Connection conn;
   // 문장 전송 객체
   private PreparedStatement ps;
   // URL
   private final String URL = "jdbc:oracle:thin:@211.238.142.81:1521:ORCL";
   // DRIVER
   private final String DRIVER="oracle.jdbc.driver.OracleDriver"; //오라클 드라이버 클래스
   //USER NAME
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
   public void getConnection(){
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
      } catch (Exception ex) {}
   }
   // 기능
   // 1. emp에 등록된 사원 목록을 출력 JOIN
   public ArrayList<EmpDTO> empAllData()
   {
      ArrayList<EmpDTO> list=new ArrayList<EmpDTO>();
      try 
      {
         getConnection(); //연결
         String sql="SELECT empno,ename,job,dname,loc,grade FROM emp,dept,salgrade WHERE emp.deptno=dept.deptno AND sal BETWEEN losal AND hisal";
         // 오라클 전송
         ps=conn.prepareStatement(sql);
         // SQL문장을 실행후에 결과를 받는다
         ResultSet rs=ps.executeQuery(); //rs가 결과값 가지고 있음
         while(rs.next())
         {
            EmpDTO d=new EmpDTO();
            d.setEmpno(rs.getInt(1));
            d.setEname(rs.getString(2));
            d.setJob(rs.getString(3));
            d.getDdto().setDname(rs.getString(4));
            d.getDdto().setLoc(rs.getString(5));
            d.getSdto().setGrade(rs.getInt(6));
            list.add(d);
            
         }
         rs.close();
      } catch (Exception ex) 
      {
         System.out.println(ex.getMessage());
      }
      finally
      {
         disConnection();
      }
      return list;
   }
   // 2. emp에 등록된 사원의 상세보기 JOIN
   public EmpDTO empDetail(int empno)
   {
      EmpDTO d=new EmpDTO();
      return d;
   }
   // 3. emp에 찾기 => 이름,부서,입사일
   public ArrayList<EmpDTO> empFind(String column,String data)
   {
      ArrayList<EmpDTO> list=new ArrayList<EmpDTO>();
      return list;
   }

}


*/

package com.sist.dao;

/*
 * Connection : 오라클 연결 ==> Socket
 * PreparedStatement: SQL문장 전송, 결과값을 읽어온다
 * 			Reader,Writer
 * Resultset : 결과값 저장
 *             메모리
 *             
 *   1) 드라이버 등록 
 *       Class.forName("드라이버 클래스명") ojdbc6.jar
 *      ============
 *         메모리 할당 (리플렉션) : 클래스 정보를 읽어서 메모리 할당, 메소드 호출, 멤버 변수 제어
 *         
 *         => 오라클과 연결
 *    2) 오라클 연결 개겣를 얻어온다
 *        Connection => getConnection(URL,USERNAME,PW)
 *    3) SQL 문장 전솔
 *        Statement 
 *          두개의 메소드 존재
 *            = executeQuery : SELECT
 *            = executeUpdate : INSERT,UPDATE,DELETE
 *     4) 결과값 받기
 *        ResultSet
 *        SELECT ename,job,hiredate
 *        =========================
 *          ename			job			hiredate
 *        =========================
 *        							BOF
 *        =========================
 *          aaa				aaa				aaa					== next   여기부터 EOF 까지 읽어오는메소드
 *          bbb				bbb				bbb
 *          ccc				ccc				ccc 				 	== previos  여기부터 위쪽으로 (BOF)까지 읽는 메소드
 *         =========================	
 *         						EOF
 *     
 *     5) 종료 (종료 순서)
 *        ResultSet => close
 *        Statemente => close
 *        Connection => close
 *      
 *      
 *        
 
*/
import java.sql.*;
import java.util.*; //데이터를 모아야되니까 Arraylist 사용

public class EmpDAO {

	// 연결 객체 얻기
	private Connection conn;

	// 문장 전송 객체 얻어오기
	private PreparedStatement ps;

	// URL
	// ORCL = 윈도우의 폴더 느낌 (ORCL이라는 데이터 폴더 안쪽에 저장됨)
	private final String URL = "Jdbc:oracle:thin:@211.238.142.81:1521:ORCL";

	// DRIVER 설정
	// OracleDriver == 오라클에서 만들어 놓은 클래스 이름
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	// User NAME
	private final String USER = "scott";

	// User PWD
	private final String PWD = "tiger";

	// 드라이버 등록
	public EmpDAO() {
		try {
			Class.forName(DRIVER);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 연결객체 얻기
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			// conn scott/tiger cmd에 저거 날리늕거랑 같음
		} catch (Exception ex) {
		}
	}

	// 연결을했으면 닫아야됨. 닫지않으면 Connection이 계속 생성됨
	// 연결해제
	public void disConnection() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
		}
	}

	// *****************************DAO만들때마다 default 임. 연결하고 연결닫고 계속 해줘야됨!!

	// 기능작성
	// 1. emp에 등록된 사원 목록을 출력 (JOIN)
	public ArrayList<EmpDTO> empAllData() {
		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();

		try {
			// 오라클 연결
			getConnection();

			// sql 문장작성
			String sql = "SELECT empno,ename,job,dname,loc,grade " + "FROM emp,dept,salgrade "
					+ "WHERE emp.deptno=dept.deptno " + "AND sal BETWEEN losal AND hisal";
			// 오라클 전송
			ps = conn.prepareStatement(sql);

			// enter (sql 문장 실행, 문장 실행후에 결과값을 받음

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				// JOIN 걸렸을때 가져오는 방법
				EmpDTO d = new EmpDTO();
				d.setEmpno(rs.getInt(1));
				d.setEname(rs.getString(2));
				d.setJob(rs.getString(3));
				d.getDdto().setDname(rs.getString(4));
				d.getDdto().setLoc(rs.getString(5));
				d.getSdto().setGrade(rs.getInt(6));
				list.add(d);

			}
			rs.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		// 에러가 나든 안나든 무조건 닫고 시작해야되니까 finally
		finally {
			disConnection();
		}
		return list;
	}

	// 2. emp에 등록된 사원의 상세보기 (JOIN)

	public EmpDTO empDetail(int empno) {

		EmpDTO d = new EmpDTO();
		return d;
	}

	// 3. emp에 찾기 => 이름,부서,입사일로 찾기
	public ArrayList<EmpDTO> empFind(String column, String data) {

		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
		return list;

	}

}

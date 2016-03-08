/*

package com.sist.dao;
import java.sql.*;

 *   Connection : ����Ŭ ���� ==> Socket
 *   PreparedStatement : SQL ���� ���� , ������� �о�´� ==> Reader,Writer
 *   ResultSet : ����� ���� => �޸�
 *   
 *   1) ����̹� ���
 *      Class.forName("����̹� Ŭ������")    ojdbc6.jar(�ݵ�� �����ؾ��� => ����Ŭ�� application�� �������ִ� ���� => thin driver)
 *      =============
 *         �޸� �Ҵ� (���÷���) : Ŭ���������� �о �޸� �Ҵ�, �޼ҵ� ȣ��, ������� ���� 
 *         new ��� x (���ռ��� ���� ���α׷��� ����� �ȵ�) => new ��ſ� Class.forName ���
 *      => ����Ŭ�� ���� �غ�
 *   2) ����Ŭ ���� ��ü�� ���´�
 *      Connection => getConnection(URL,USERNAME,PWD)
 *   3) SQL���� ����
 *      Statement
 *        = executeQuery : SELECT (��� �� �޾ƿö�)
 *        = executeUpdate : INSERT,UPDATE,DELETE (��ü������ ������ ��)
 *   4) ����� �ޱ�
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
 *   5) ����
 *      ResultSet => close
 *      Statement => close
 *      Connection => close
 *   
 
import java.util.*; //ArrayList
public class EmpDAO {
   // ���� ��ü ���
   private Connection conn;
   // ���� ���� ��ü
   private PreparedStatement ps;
   // URL
   private final String URL = "jdbc:oracle:thin:@211.238.142.81:1521:ORCL";
   // DRIVER
   private final String DRIVER="oracle.jdbc.driver.OracleDriver"; //����Ŭ ����̹� Ŭ����
   //USER NAME
   private final String USER="scott";
   // PWD
   private final String PWD="tiger";
   // ����̹� ���
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
   // ���� ��ü ���
   public void getConnection(){
      try
      {
         conn=DriverManager.getConnection(URL,USER,PWD);
         // conn scott/tiger
      }catch(Exception ex){}
   }
   // ���� ����
   public void disConnection()
   {
      try 
      {
         if(ps!=null) ps.close();
         if(conn!=null) conn.close();
      } catch (Exception ex) {}
   }
   // ���
   // 1. emp�� ��ϵ� ��� ����� ��� JOIN
   public ArrayList<EmpDTO> empAllData()
   {
      ArrayList<EmpDTO> list=new ArrayList<EmpDTO>();
      try 
      {
         getConnection(); //����
         String sql="SELECT empno,ename,job,dname,loc,grade FROM emp,dept,salgrade WHERE emp.deptno=dept.deptno AND sal BETWEEN losal AND hisal";
         // ����Ŭ ����
         ps=conn.prepareStatement(sql);
         // SQL������ �����Ŀ� ����� �޴´�
         ResultSet rs=ps.executeQuery(); //rs�� ����� ������ ����
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
   // 2. emp�� ��ϵ� ����� �󼼺��� JOIN
   public EmpDTO empDetail(int empno)
   {
      EmpDTO d=new EmpDTO();
      return d;
   }
   // 3. emp�� ã�� => �̸�,�μ�,�Ի���
   public ArrayList<EmpDTO> empFind(String column,String data)
   {
      ArrayList<EmpDTO> list=new ArrayList<EmpDTO>();
      return list;
   }

}


*/

package com.sist.dao;

/*
 * Connection : ����Ŭ ���� ==> Socket
 * PreparedStatement: SQL���� ����, ������� �о�´�
 * 			Reader,Writer
 * Resultset : ����� ����
 *             �޸�
 *             
 *   1) ����̹� ��� 
 *       Class.forName("����̹� Ŭ������") ojdbc6.jar
 *      ============
 *         �޸� �Ҵ� (���÷���) : Ŭ���� ������ �о �޸� �Ҵ�, �޼ҵ� ȣ��, ��� ���� ����
 *         
 *         => ����Ŭ�� ����
 *    2) ����Ŭ ���� ������ ���´�
 *        Connection => getConnection(URL,USERNAME,PW)
 *    3) SQL ���� ����
 *        Statement 
 *          �ΰ��� �޼ҵ� ����
 *            = executeQuery : SELECT
 *            = executeUpdate : INSERT,UPDATE,DELETE
 *     4) ����� �ޱ�
 *        ResultSet
 *        SELECT ename,job,hiredate
 *        =========================
 *          ename			job			hiredate
 *        =========================
 *        							BOF
 *        =========================
 *          aaa				aaa				aaa					== next   ������� EOF ���� �о���¸޼ҵ�
 *          bbb				bbb				bbb
 *          ccc				ccc				ccc 				 	== previos  ������� �������� (BOF)���� �д� �޼ҵ�
 *         =========================	
 *         						EOF
 *     
 *     5) ���� (���� ����)
 *        ResultSet => close
 *        Statemente => close
 *        Connection => close
 *      
 *      
 *        
 
*/
import java.sql.*;
import java.util.*; //�����͸� ��ƾߵǴϱ� Arraylist ���

public class EmpDAO {

	// ���� ��ü ���
	private Connection conn;

	// ���� ���� ��ü ������
	private PreparedStatement ps;

	// URL
	// ORCL = �������� ���� ���� (ORCL�̶�� ������ ���� ���ʿ� �����)
	private final String URL = "Jdbc:oracle:thin:@211.238.142.81:1521:ORCL";

	// DRIVER ����
	// OracleDriver == ����Ŭ���� ����� ���� Ŭ���� �̸�
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	// User NAME
	private final String USER = "scott";

	// User PWD
	private final String PWD = "tiger";

	// ����̹� ���
	public EmpDAO() {
		try {
			Class.forName(DRIVER);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// ���ᰴü ���
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			// conn scott/tiger cmd�� ���� �����d�Ŷ� ����
		} catch (Exception ex) {
		}
	}

	// ������������ �ݾƾߵ�. ���������� Connection�� ��� ������
	// ��������
	public void disConnection() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
		}
	}

	// *****************************DAO���鶧���� default ��. �����ϰ� ����ݰ� ��� ����ߵ�!!

	// ����ۼ�
	// 1. emp�� ��ϵ� ��� ����� ��� (JOIN)
	public ArrayList<EmpDTO> empAllData() {
		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();

		try {
			// ����Ŭ ����
			getConnection();

			// sql �����ۼ�
			String sql = "SELECT empno,ename,job,dname,loc,grade " + "FROM emp,dept,salgrade "
					+ "WHERE emp.deptno=dept.deptno " + "AND sal BETWEEN losal AND hisal";
			// ����Ŭ ����
			ps = conn.prepareStatement(sql);

			// enter (sql ���� ����, ���� �����Ŀ� ������� ����

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				// JOIN �ɷ����� �������� ���
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

		// ������ ���� �ȳ��� ������ �ݰ� �����ؾߵǴϱ� finally
		finally {
			disConnection();
		}
		return list;
	}

	// 2. emp�� ��ϵ� ����� �󼼺��� (JOIN)

	public EmpDTO empDetail(int empno) {

		EmpDTO d = new EmpDTO();
		return d;
	}

	// 3. emp�� ã�� => �̸�,�μ�,�Ի��Ϸ� ã��
	public ArrayList<EmpDTO> empFind(String column, String data) {

		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
		return list;

	}

}

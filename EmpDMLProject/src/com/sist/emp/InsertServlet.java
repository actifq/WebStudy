/*package com.sist.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���� Ÿ�� ���� : text/html,text/xml
		response.setContentType("text/html;charset=EUC-KR");

		PrintWriter out = response.getWriter();
		// getOutputStream
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>��� ���</h3>");
		out.println("<form action=InsertServlet method=POST>");

		out.println("<table border=1 bordercolor=black width=300 cellspacing=0>");

		out.println("<tr>");
		out.println("<td width=25% align=right>�̸�</td>");
		out.println("<td width=75% align=left>");
		out.println("<input type=text size=12 name=ename>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=25% align=right>����</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=job>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=25% align=right>���</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=mgr>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=25% align=right>�޿�</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=sal>");
		out.println("<option>1000</option>");
		out.println("<option>2000</option>");
		out.println("<option>3000</option>");
		out.println("<option>4000</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=25% align=right>������</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=comm>");
		out.println("<option>0</option>");
		out.println("<option>100</option>");
		out.println("<option>200</option>");
		out.println("<option>300</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=25% align=right>�μ�</td>");
		out.println("<td width=75% align=left>");
		// <select><option> �޺��ڽ� ������ �ɼǰ����� �־���
		out.println("<select name=deptno>");
		out.println("<option>10</option>");
		out.println("<option>20</option>");
		out.println("<option>30</option>");
		out.println("<option>40</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan=2 align=center>");
		out.println("<input type=submit value=���>");
		out.println("<input type=button value=��� onclick=\"javascript:history.back()\">");
		// ==================
		// \" \" javascript ��� javascript: <- �̹� �����ϴ� �Լ� ���
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���� �޾Ƽ� ó��
		request.setCharacterEncoding("EUC-KR");
		String ename=request.getParameter("ename");
		System.out.println(ename);
		// DAO => Insert
		// ������ �̵� (List)
		
		// ������ �ٲܶ� ��� (sendRedirect)
		response.sendRedirect("EmpListServlet");
	}

}


 * ���� ����� & �޾Ƽ� ó�����ִ� ��
 * 
 * 
 
*/
package com.sist.emp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDTO;
import java.util.*;
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���� Ÿ�� ���� : text/html,text/xml
		response.setContentType("text/html;charset=EUC-KR");

		EmpDAO dao=new EmpDAO();
		List<String> jList=dao.empGetJob();
		List<Integer> mList=dao.empGetMger() ;
		
		PrintWriter out = response.getWriter();
		// getOutputStream
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>��� ���</h3>");
		out.println("<form action=InsertServlet method=POST>");
		out.println("<table border=1 bordercolor=black width=300 cellspacing=0>");

		out.println("<tr>");
		out.println("<td width=25% align=right>�̸�</td>");
		out.println("<td width=75% align=left>");
		out.println("<input type=text size=12 name=ename>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=25% align=right>����</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=job>");

		for(String job:jList){
			out.println("<option>");
			out.println(job);
			out.println("</option>");
		}
		

		
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=25% align=right>���</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=mgr>");

		for(int mgr:mList){
			out.println("<option>");
			out.println(mgr);
			out.println("</option>");
		}
		

		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=25% align=right>�޿�</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=sal>");
		out.println("<option>1000</option>");
		out.println("<option>2000</option>");
		out.println("<option>3000</option>");
		out.println("<option>4000</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=25% align=right>������</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=comm>");
		out.println("<option>0</option>");
		out.println("<option>100</option>");
		out.println("<option>200</option>");
		out.println("<option>300</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=25% align=right>�μ�</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=deptno>");
		out.println("<option>10</option>");
		out.println("<option>20</option>");
		out.println("<option>30</option>");
		out.println("<option>40</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan=2 align=center>");
		out.println("<input type=submit value=���>");
		out.println("<input type=button value=��� onclick=\"javascript:history.back()\">");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���� �޴´�
		request.setCharacterEncoding("EUC-KR");
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		String mgr = request.getParameter("mgr");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		String deptno = request.getParameter("deptno");
		
		//DTO�� �ٽ� �� ����ֱ�
		EmpDTO d=new EmpDTO();
		d.setEname(ename);
		d.setJob(job);
		d.setMgr(Integer.parseInt(mgr));
		d.setSal(Integer.parseInt(sal));
		d.setComm(Integer.parseInt(comm));
		d.setDeptno(Integer.parseInt(deptno));
		
		// DAO => Insert
		EmpDAO dao=new EmpDAO();
		dao.empInsert(d);
		// ������ �̵� (List)
		response.sendRedirect("EmpListServlet");
	}

}






















package com.sist.view;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;

public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ================ ====================
		// InPut Outputed
		// �޴����� �϶� ������ ������
		response.setContentType("text/html;charset=EUC-KR");
		// xml/html �ۿ� ������ , �ѱ۷� �����ڴ�
		PrintWriter out = response.getWriter();
		// OutputedStream out=s.getOutputSteam();

		// ������ �������� �ޱ�
		// list�ȿ� DB���� ������ �����͸� �� �־����
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpDTO> list = dao.empAllData();

		// ȭ�����
		/*
		 * html => ML ==== �±�<>
		 * 
		 * ������� => �±� + �Ӽ� <table border=0> </table> <br/> empty tag (�ܵ� �±�)
		 */
		out.println("<html>");

		// head���� ��Ÿ�� �ƴϸ� js �� ��
		out.println("<head>");

		out.println("<style type=text/css>");
		out.println("th,td{font-family:���� ���;font-size:10pt}");

		// ������ (id = #a�� ������, Ŭ������ .a�� ����
		out.println("a{text-decoration:none;color:black}");
		out.println("a:hover{text-decoration:underline;color:green}");

		out.println("</style>");
		out.println("</head>");

		out.println("<body>");
		out.println("<center>");
		out.println("<br/>");
		out.println("<h3>��� ���</h3>");
		out.println("<table border=0 width=600>");
		out.println("<tr bgcolor=#ccccff>");

		// Ÿ�̺� �ִ°� (table header �β����)
		out.println("<th>���</th>");
		out.println("<th>�̸�</th>");
		out.println("<th>����</th>");
		out.println("<th>�μ���</th>");
		out.println("<th>�ٹ���</th>");
		out.println("<th>���</th>");
		out.println("</tr>");

		// 404 ������ ��ã�� ����
		// 500 �ҽ�����
		for (EmpDTO d : list) {
			out.println("<tr align=center>");
			out.println("<td>" + d.getEmpno() + "</td>");
			out.println("<td>");

			// ������ �����°�=> ?
			// ���� �������� �����͸� �����Ҷ� ���� ���

			out.println("<a href=EmpDetailServlet?empno=" + d.getEmpno() + ">");
			out.println(d.getEname() + "</a>");

			out.println("</td>");
			out.println("<td>" + d.getJob() + "</td>");
			out.println("<td>" + d.getDdto().getDname() + "</td>");
			out.println("<td>" + d.getDdto().getLoc() + "</td>");
			out.println("<td>" + d.getSdto().getGrade() + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");

		// �� ������ �������� ���� �ϳ� ��
		out.println("<hr width=600>");
		out.println("<table border=0 width=600>");
		out.println("<tr>");
		out.println("<td align=left>");

		out.println("</td>");

		out.println("<Search:>");

		// �޺��ڽ� ���鶧
		out.println("<select>");

		// �����ִ°� �̸�,�μ�,�Ի����� �������µ� �ѱ涧�� value ���� �Ѱ���
		out.println("<option value=ename>�̸�</option>");
		out.println("<option value=deptno>�μ�</option>");
		out.println("<option value=hiredate>�Ի���</option>");
		out.println("</select>");
		
		//input type �ؽ�Ʈ �ڽ� �ϳ� ������ִ°�
		out.println("<input type=text size=12>");
		out.println("<input type=button value=ã��>");
		/*
		 *  1) �Է¶�
		 *       <input type=()>
		 *       type=text : ���ٹ��ڿ�
		 *       type=password : ��й�ȣ
		 *       type=checkbox : üũ�ڽ�
		 *       type=radio : ���� ��ư
		 *       type=image ==> button (submit ==> �ѹ� Ŭ���ϸ� �����͸� �����ϴ� ��ư)
		 *       type=submit : ������ ���� ��ư
		 *       type=reset : �ʱ�ȭ ��ư
		 * 	  type=button : ����� ���� (JS���̿��ؾߵ�)
		 * 	  ========================= ����
		 * 
		 * 	  type=date
		 *       type=number
		 *       type=email
		 *       type=updown
		 *       ========================== HTML 5
		 *
		 *       <textarea> : ������ �Է�
		 *       <select> : �޺��ڽ�
		 *       
		 *       <br> : \ n
		 *       <p> : <br><br> �ܶ� �����°�
		 *       &nbsp : ����
		 *       <hr> : ����
		 *       <a> : ��ũ
		 *       <img> : �̹��� ����Ҷ�
		 *       ===========================
		 *       ���â
		 *       <table>
		 *       <div>
		 *       ===========================
		 *       <form> : ���۹��, ������ ����
		 *       ===========================
		 *       <fieldset> : �ʵ带 ��Ƽ� �ѹ��� ó���Ҷ�
		 *       ===========================       
		 *      <nav>
		 *      <header> : ȭ�� ��Ȱ
		 *      <section>
		 *      <aside>
		 *      <footer> 
		 *       ===========================
		 */   
		
		out.println("</tr>");
		out.println("</table>");

		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

	}

}



























// ���μ��� ��Ȱ ����
// ���� ���� �ϳ� �����Ŀ� �ڹ� Ŭ���� ���Ͽ��ٰ� extends �κи� ���� �� �ٿ� ������ �ڵ����� Servlet������

package com.sist.view;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		
		out.println("<table border=1 width=1000 height 780>");
		
		String str="HeaderServlet";
		// ���
		out.println("<tr>");
		RequestDispatcher rd=request.getRequestDispatcher(str);
		out.println("<td height=100 colspan=2>");
		rd.include(request, response);
		out.println("</td>");
		out.println("</tr>");
		

		out.println("<tr>");
		out.println("<td height=580 width=200>&nbsp;</td>");
		out.println("<td height=580 width=800 val"
				+ "ign=top>");
		rd=request.getRequestDispatcher("gugudan.jsp");
		rd.include(request, response);
		out.println("</td>");
		out.println("</tr>");
		
		//Ǫ��
		out.println("<tr>");
		out.println("<td height=100 colspan=2>&nbsp;</td>");
		out.println("</tr>");
		
		out.println("</table>");
		
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}

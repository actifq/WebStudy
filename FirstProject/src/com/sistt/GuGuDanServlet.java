package com.sistt;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class GuGuDanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>구구단</h3>");
		out.println("<table border=1 width=600>");
		out.println("<tr>");

		for (int i = 2; i <= 9; i++) {
			out.println("<th>" + i + "단</th>");
			for (int j = 2; j <= 9; j++) {
				out.println("<td>");
				out.print(j + "*" + i + "=" + (j * i));
				out.println("</td>");
			}
		}

		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

		/*
		 * == OutputStream out=s.getOutputStream()
		 * 
		 * byte 단위로 전송과 문자열 단위 전송의 차이임 (PrintWrite 문자열 단위로 전송함)
		 */
	}

}

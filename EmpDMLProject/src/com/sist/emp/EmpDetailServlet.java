package com.sist.emp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.EmpDAO;

/*
 * 예약 프로그램 : (영화), 콘도, 열차, 맛집,여행사
 * 결재 : 은행, (쇼핑몰)
 *  - 결재 서버를 따로 만들어야됨 
 *  멀티미디어 : 아프리카TV, 멜론, 유튜브 
 *  관리 프로그램 : 매장관리... 
 *  ERP : 출결체크, 전자문서
 *  기타 : 모임 
 *  
 * 
 */
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 응답 타입 결정 : text/html,text/xml
		response.setContentType("text/html;charset=EUC-KR");
		//EmpDAO d=new EmpDAO();
		int getEname=0;
		
		String strPage=request.getParameter("empno");
		getEname=Integer.parseInt(strPage);
		
		PrintWriter out = response.getWriter();
		// getOutputStream
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>사원 상세보기</h3>");
		
		out.println("<form action=InsertServlet method=POST>");
		out.println("<table border=1 bordercolor=black width=300 cellspacing=0>");

		out.println("<tr>");
		out.println("<td width=25% align=right>이름</td>");
		out.println("<td width=75% align=left>");
		out.println("<input type=text size=12 name=ename>");
		
		
		
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=25% align=right>직위</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=job>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=25% align=right>사수</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=mgr>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=25% align=right>급여</td>");
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
		out.println("<td width=25% align=right>성과급</td>");
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
		out.println("<td width=25% align=right>부서</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=deptno>");
		out.println("<option>10</option>");
		out.println("<option>20</option>");
		out.println("<option>30</option>");
		out.println("<option>40</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");
		out.println("</form>");
		
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

	}


}

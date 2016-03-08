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
		// 받는정보 일때 정보를 보낼때
		response.setContentType("text/html;charset=EUC-KR");
		// xml/html 밖에 못읽음 , 한글로 보내겠다
		PrintWriter out = response.getWriter();
		// OutputedStream out=s.getOutputSteam();

		// 데이터 보내기전 받기
		// list안에 DB에서 가져온 데이터를 다 넣어놓음
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpDTO> list = dao.empAllData();

		// 화면출력
		/*
		 * html => ML ==== 태그<>
		 * 
		 * 구성요소 => 태그 + 속성 <table border=0> </table> <br/> empty tag (단독 태그)
		 */
		out.println("<html>");

		// head에는 스타일 아니면 js 가 들어감
		out.println("<head>");

		out.println("<style type=text/css>");
		out.println("th,td{font-family:맑은 고딕;font-size:10pt}");

		// 셀렉터 (id = #a로 가져옴, 클래스는 .a가 붙음
		out.println("a{text-decoration:none;color:black}");
		out.println("a:hover{text-decoration:underline;color:green}");

		out.println("</style>");
		out.println("</head>");

		out.println("<body>");
		out.println("<center>");
		out.println("<br/>");
		out.println("<h3>사원 목록</h3>");
		out.println("<table border=0 width=600>");
		out.println("<tr bgcolor=#ccccff>");

		// 타이블 주는거 (table header 두꺼운거)
		out.println("<th>사번</th>");
		out.println("<th>이름</th>");
		out.println("<th>직위</th>");
		out.println("<th>부서명</th>");
		out.println("<th>근무지</th>");
		out.println("<th>등급</th>");
		out.println("</tr>");

		// 404 파일을 못찾는 에러
		// 500 소스에러
		for (EmpDTO d : list) {
			out.println("<tr align=center>");
			out.println("<td>" + d.getEmpno() + "</td>");
			out.println("<td>");

			// 데이터 보내는거=> ?
			// 받은 서블릿으로 데이터를 전송할때 쓰는 방식

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

		// 다 들어오고 마지막에 수평선 하나 줌
		out.println("<hr width=600>");
		out.println("<table border=0 width=600>");
		out.println("<tr>");
		out.println("<td align=left>");

		out.println("</td>");

		out.println("<Search:>");

		// 콤보박스 만들때
		out.println("<select>");

		// 보여주는건 이름,부서,입사일이 보여지는데 넘길때는 value 값을 넘겨줌
		out.println("<option value=ename>이름</option>");
		out.println("<option value=deptno>부서</option>");
		out.println("<option value=hiredate>입사일</option>");
		out.println("</select>");
		
		//input type 텍스트 박스 하나 만들어주는거
		out.println("<input type=text size=12>");
		out.println("<input type=button value=찾기>");
		/*
		 *  1) 입력란
		 *       <input type=()>
		 *       type=text : 한줄문자열
		 *       type=password : 비밀번호
		 *       type=checkbox : 체크박스
		 *       type=radio : 라디오 버튼
		 *       type=image ==> button (submit ==> 한번 클릭하면 데이터를 전송하는 버튼)
		 *       type=submit : 데이터 전송 버튼
		 *       type=reset : 초기화 버튼
		 * 	  type=button : 기능이 없음 (JS를이용해야됨)
		 * 	  ========================= 공통
		 * 
		 * 	  type=date
		 *       type=number
		 *       type=email
		 *       type=updown
		 *       ========================== HTML 5
		 *
		 *       <textarea> : 여러줄 입력
		 *       <select> : 콤보박스
		 *       
		 *       <br> : \ n
		 *       <p> : <br><br> 단락 나누는거
		 *       &nbsp : 공백
		 *       <hr> : 수평선
		 *       <a> : 링크
		 *       <img> : 이미지 출력할때
		 *       ===========================
		 *       출력창
		 *       <table>
		 *       <div>
		 *       ===========================
		 *       <form> : 전송방식, 전송할 파일
		 *       ===========================
		 *       <fieldset> : 필드를 모아서 한번에 처리할때
		 *       ===========================       
		 *      <nav>
		 *      <header> : 화면 분활
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



























<!--  -->

<%--

			1) 지시자 <%@ 지시자명 속성="값" 속성="값" .... %>
					page
						= contentType="text/html(xml);charsey=euc-kr,utf-8"
						= import="java.util.*, java.text.*"
						= errorPage="파일명"
					=====================================					
					include
						= file="파일명"
					taglib
						= prefix="c" <c:forEach...>
							 		="core" <core:forEach...>
						= uri="경로명"
			2) jsp는 _jspService(){코딩}
				run()
				{
					case Function.LOGIN:
								(코딩)
				}
		 	3)jsp는 HTML + Java : 구분을 해줘야함
		 		
		 		<%
		 				일반 자바 코딩
		 		%> 스크립트릿
		 		
		 		<%!
		 				메소드
		 				멤버변수 
		 		%> 	선언식
		 		
		 		<%=
		 				표현식
		 		%>
 --%>

<%@page import="java.text.SimpleDateFormat"%>
<%!
	public int add(int a,int b){
	return a+b;
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ page import="java.util.*,java.text.*" errorPage="errer.jsp"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	

	<%
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String today=sdf.format(date);
		int a=10/0;
	%>
 	<%= today %><br>
 	a:<%=a %>
 	

</body>
</html>


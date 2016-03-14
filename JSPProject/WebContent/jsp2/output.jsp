<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
			// request.setCharacterEncoding("EUC-KR"); // POST 방식일때 처리하는 방법
			
			// 겟방식은 디코딩을 톰켓 내부에서 해주기때문에 톰켓-server.xml 들어가서
			// 63번째 줄 <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="EUC-KR"/> 
			// 마지막줄 URIEncoding을 수정해줘야함
			
			String name=request.getParameter("name");
	%>
	<%= name %>
</body>
</html>
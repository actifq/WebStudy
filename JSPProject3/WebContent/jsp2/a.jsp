<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>A.jps</h1>
	</center>
	<%-- 
	<%
			RequestDispatcher rd=request.getRequestDispatcher("b.jsp");
			rd.forward(request, response);
	%> --%>
	
	<%
		response.sendRedirect("b.jsp");
	%>
</body>
</html>
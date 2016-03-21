<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--
	해당 페이지에 내장객체를 얻어올때 (pageContext)
		request => pageContext.getRequest()
 --%>

<%
	String temp=request.getParameter("no");
	String jsp="";
	if(temp==null)
		temp="1";
	int no=Integer.parseInt(temp);
	
	if(no==1)
		jsp="header.jsp";
	
	else
		jsp="test.jsp";
		
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>

		<table border=1 bordercolor="black" width=800 height=600>
			<tr>
				<td colspan="2" height=100>
				<% pageContext.include(jsp); %>
				</td>
			</tr>

			<tr>
				<td width=300 height=400>
				<% pageContext.include("navi.jsp"); %>
				</td>

				<td width=500 height=400>
				<%pageContext.include("content.jsp"); %>
				</td>
			</tr>

			<tr>
				<td colspan="2" height=100>
				<%pageContext.include("footer.jsp"); %>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>
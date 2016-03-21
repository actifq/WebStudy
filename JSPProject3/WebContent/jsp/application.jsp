<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--
		application ��ü : ServletContext 
			= ��������
				1) getServerInfo() ==> Tomcat
					3.1	
				2) getMajorVersion()
				3) getMinorVersion()
			= web.xml�� �о� ����
				1) getInitParameter()
			###########�߿� = log file ����� �� ����
				1) log
			###########�߿� = ���� ��θ� �о����
				1) getRealPath()
 --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
������:<%= application.getServerInfo() %><br>
����:<%= application.getMajorVersion()+"."+application.getMinorVersion() %>

<%
String driver=application.getInitParameter("driver");
String url=application.getInitParameter("url");
String user=application.getInitParameter("username");
String pwd=application.getInitParameter("password");

application.log("Driver:"+driver);
application.log("URL:"+url);
application.log("UserName:"+user);
application.log("Password:"+pwd);

%>
<br>
<%=
application.getRealPath("application.jsp")
%>
</body>
</html>
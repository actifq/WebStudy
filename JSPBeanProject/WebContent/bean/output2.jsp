<%@page import="com.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
    request.setCharacterEncoding("EUC-KR");
    /* String name=request.getParameter("name");
    String sex=request.getParameter("sex");
    String tel1=request.getParameter("tel1");
    String tel2=request.getParameter("tel2");
    String tel3=request.getParameter("tel3");
    MemberBean m=new MemberBean();
    m.setName(name);
    m.setSex(sex);
    m.setTel1(tel1);
    m.setTel2(tel2);
    m.setTel3(tel3); */
%>
<jsp:useBean id="m" class="com.bean.MemberBean">
  <jsp:setProperty name="m" property="*"/>
</jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
이름:<%=m.getName() %><br>
성별:<%=m.getSex() %><br>
전화:<%=m.getTel() %>
</body>
</html>
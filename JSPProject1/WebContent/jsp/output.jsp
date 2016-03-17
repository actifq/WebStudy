<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
    request.setCharacterEncoding("EUC-KR");
    //<input type=text name=name size=12>
    String name=request.getParameter("name");
    String sex=request.getParameter("sex");
    String tel1=request.getParameter("tel1");
    String tel2=request.getParameter("tel2");
    String[] hobby=request.getParameterValues("hobby");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <h3>개인정보 출력</h3>
  이름:<%=name %><br>
 성별:<%=sex %><br>
 전화:<%=tel1 %>)<%=tel2 %><br><%-- 010)123-1234 --%>
 취미:<br>
 <ul>
  <%
     if(hobby!=null)
     {
      for(String s:hobby)
      {
  %>
         <li><%=s %></li>
  <%
      }
     }
  %>
 </ul>
</body>
</html>






<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.member.dao.*"%>
   <%
   
   request.setCharacterEncoding("EUC-KR");
   
   %>
   
   <jsp:useBean id="dao" class="com.member.dao.MemberDAO"/>
   <jsp:useBean id="dto" class="com.member.dao.MemberDTO">
   
      
   		<jsp:setProperty name="dto" property="*"/>
  </jsp:useBean>

<%
	dao.memberJoin(dto);
	response.sendRedirect("../main/main.jsp?mode=2");
%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.member.dao.*" %>
<%
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	MemberDAO dao=new MemberDAO();
	String result=dao.isLogin(id, pwd);
	if(result.equals("NOID"))
	{
%>
		<script>
		alert("ID�� �������� �ʽ��ϴ�");
		hitsory.back();
		</script>

<%
	}
	else if(result.equals("NOPWD"))
	{
%>
		<script>
		alert("��й�ȣ�� Ʋ���ϴ�.");
		history.back();
		</script>
<%
	}
	else //�α��ε�
	{
		// ID,NAME ���� ==> Session
		session.setAttribute("id",id);
		session.setAttribute("name",result);
		response.sendRedirect("../main/main.jsp");
	}
%>

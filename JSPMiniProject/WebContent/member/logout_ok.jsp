<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	session.invalidate(); //���ǿ� ����� ��� ������ ����
	response.sendRedirect("../main/main.jsp");
%>
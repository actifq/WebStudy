<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

	String path="c://download";

	// �ѱ����� ���� �� �ְ�
	String enctype="EUC-KR";
	
	int size=1024*1024*100;
	MultipartRequest mr=new MultipartRequest(request,path,size,enctype,new DefaultFileRenamePolicy());
																											// ���� ���ϸ����� �� ��
%>
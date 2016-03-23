<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

	String path="c://download";

	// 한글파일 받을 수 있게
	String enctype="EUC-KR";
	
	int size=1024*1024*100;
	MultipartRequest mr=new MultipartRequest(request,path,size,enctype,new DefaultFileRenamePolicy());
																											// 같은 파일명있을 때 ㄲ
%>
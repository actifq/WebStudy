<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URLEncoder,java.net.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String fn=request.getParameter("fn");
	response.setHeader("Content-Disposition", "attachment;filename="
											  +URLEncoder.encode(fn,"EUC-KR"));
	File file=new File("c:\\download\\"+fn);
	response.setContentLength((int)file.length());
	BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
	BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
	// response.getOutputStream => client�� �̿��Ҷ� ��� (Ŭ���̾�Ʈ ip������ ����)
	int i=0; //�о�� byte(�ٿ�������� ������ byte)
	byte[] buffer=new byte[1024];
	while((i=bis.read(buffer,0,1024))!=-1) //-1:eof(������ ��)
	{
		bos.write(buffer,0,i);
	}
	bis.close();
	bos.close();
%>

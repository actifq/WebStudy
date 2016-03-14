<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%--
    
    		���尴ü (�⺻��ü)
    				= request :  HttpServeletRequest(�̰� �̸� ��������ְ� �̰ż� ���� ��ü�� request)
    						1) Ŭ���̾�Ʈ�� ��û����
    							setCharacterEncoding() -- �ѱۺ�ȯ�� ���� �ڵ� (Tomcat�� Server.xml �ȿ� �߰�)
    							getParameter() : ���� ������
    							getParameterValues() : ���� ������
    								=> id,sex,name 
    								=> id=aaa&sex=man&name=hong
    								=> hobby=aaa&hobby=bbb&hobby=ccc   (getParameterValuses())
    						2) Ŭ���̾�Ʈ�� ������ ������ ������ ����
	    						--http://localhost/JSPProject/jsp3/info.jsp
    							getRequestURL()
    							
    							--/JSPProject/jsp3/info.jsp
    							getRequestURI()
    							
    							--/JSPProject
    							getContextPath()
    							
    							getMethod()
    							
    							--������ ����� ������ ������
    							getRemoteAddr()
    						3) ���� ���� 
    							getServerName()
    							getServerPort()
    							getProtocol()	
    						4)Session,cookie ���� ���
    							getSession()
    							getProtocol()
    				= response
    				= session
    				= out
    				= application : log���� ������ �� ���
    				= pageContext => <jsp:include> <jsp:forward>
    				= page => this
    				= config => web.xml
    				= exception => try~catch
    
     --%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h3>Request����</h3>
	
	Ŭ���̾�Ʈ IP:<%=request.getRemoteAddr() %><br>
	URL:<%=request.getRequestURL() %><br>
	URI:<%=request.getRequestURI() %><br>
	Method:<%=request.getMethod() %><br>
	Protocal:<%=request.getProtocol() %><br>
	ServerName:<%=request.getServerName() %><br>
	ServerPort:<%=request.getServerPort() %><br>
	ContextPath:<%=request.getContextPath() %><br>
	
	<%--
	http://localhost/JSPProject/jsp3/info.jsp
	===   ===== ===============    
	protocal 																��
				servername      URI									�� ���� �� ���ļ� URL
	 --%>
		
	</center>
</body>
</html>
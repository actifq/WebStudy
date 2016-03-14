<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%--
    
    		내장객체 (기본객체)
    				= request :  HttpServeletRequest(이건 미리 만들어져있고 이거셍 대한 객체가 request)
    						1) 클라이언트의 요청정보
    							setCharacterEncoding() -- 한글변환을 위한 코드 (Tomcat에 Server.xml 안에 추가)
    							getParameter() : 단일 데이터
    							getParameterValues() : 다중 데이터
    								=> id,sex,name 
    								=> id=aaa&sex=man&name=hong
    								=> hobby=aaa&hobby=bbb&hobby=ccc   (getParameterValuses())
    						2) 클라이언트의 브라우저 정보를 가지고 있음
	    						--http://localhost/JSPProject/jsp3/info.jsp
    							getRequestURL()
    							
    							--/JSPProject/jsp3/info.jsp
    							getRequestURI()
    							
    							--/JSPProject
    							getContextPath()
    							
    							getMethod()
    							
    							--접속한 사람의 정보를 가져옴
    							getRemoteAddr()
    						3) 서버 정보 
    							getServerName()
    							getServerPort()
    							getProtocol()	
    						4)Session,cookie 생성 기능
    							getSession()
    							getProtocol()
    				= response
    				= session
    				= out
    				= application : log파일 제작할 때 사용
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
	<h3>Request정보</h3>
	
	클라이언트 IP:<%=request.getRemoteAddr() %><br>
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
	protocal 																│
				servername      URI									└ 세개 다 합쳐서 URL
	 --%>
		
	</center>
</body>
</html>
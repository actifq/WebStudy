<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
 <%-- 
 
 	1) request (HttpServletRequest)
 		=> 클라이언트에서 보내주는 요청값만 받아온다
 	2) response (HttpServletResponse)
 		=> 페이지 이동
 	3) out(JspWriter)
 		=> 출력 메모리와 관련 (출력버퍼)
 		=> 메모리에 출력
 			println(), print()
 			out.println("aaa");
 		=> 출력 크기 확인
 			getBufferSize()
 		=> 남아 있는 버퍼 크기 확인
 			getRemainning()
 			
 			****** default : 8kb 로 되어있음
 			****** 클라이언트 브라우저에서 ==> 메모리에 있는 데이터를 읽어 갈때 자동으로 AutoFlush
 			
 			outl.println() ==> <%= %>
 	
 
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	실제 메모리 출력 크기 확인 : <%= out.getBufferSize() %>
	남아 있는 버퍼 크기 : <%= out.getRemaining() %>
	사용중인 버퍼 크기 : <%= out.getBufferSize()-out.getRemaining()%>
</body>
</html>


























<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
 <%-- 
 
 	1) request (HttpServletRequest)
 		=> Ŭ���̾�Ʈ���� �����ִ� ��û���� �޾ƿ´�
 	2) response (HttpServletResponse)
 		=> ������ �̵�
 	3) out(JspWriter)
 		=> ��� �޸𸮿� ���� (��¹���)
 		=> �޸𸮿� ���
 			println(), print()
 			out.println("aaa");
 		=> ��� ũ�� Ȯ��
 			getBufferSize()
 		=> ���� �ִ� ���� ũ�� Ȯ��
 			getRemainning()
 			
 			****** default : 8kb �� �Ǿ�����
 			****** Ŭ���̾�Ʈ ���������� ==> �޸𸮿� �ִ� �����͸� �о� ���� �ڵ����� AutoFlush
 			
 			outl.println() ==> <%= %>
 	
 
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	���� �޸� ��� ũ�� Ȯ�� : <%= out.getBufferSize() %>
	���� �ִ� ���� ũ�� : <%= out.getRemaining() %>
	������� ���� ũ�� : <%= out.getBufferSize()-out.getRemaining()%>
</body>
</html>


























<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<body>

	<%--
		int even=0;
		int odd=0;
	
		for(int i=1;i<=10;i++){
			if(i%2==0)
				even+=i;
			else
				odd+=i;
		}
	%>
	
	¦���� ��:<%=even %> <br>
	Ȧ���� ��:<%=odd --%>
	
	<%
		for(int i=0;i<=10;i++){
			if(i%2==0){
				//out.println(i+"&nbsp;");					//���� ��� �ڵ�
				%>
				<%=i %>
				
				<%
			}
		}
		%>

</body>
</html>
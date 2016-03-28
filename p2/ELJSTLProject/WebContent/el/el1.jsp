<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
      EL (ǥ�����) => ������ ȭ�� ��� 
      => ����  ${��¹�}
         1) ${param.id} => request.getParameter("id");
         2) ${requestScope.id}
            request.getAttribute("id")
            => ${id}
         3) ${sessionScope.id}
            session.getAttribute("id")
      => ������ 
         1) ��������� 
            + , - , * , / , %
            / => ����� �Ǽ��� 
            ${ 10+10 } ==> 20
            ${ "10"+1} ==> Integer.parseInt("10")+1
                       ==> 11 
                       ==> ��������ڴ� ����� ó�� (���ڿ� ����((X))
            ${ null +1 } ==> null(0���� ��ȯ) ==> 1
            ${ 5/2 } ==> 2.5
            ==> ${ 5 div 2 }
            ${ 5%2 } ==> 1
            ==> ${ 5 mod 2} ==> 1
         2) �񱳿�����
            ==(eq),!=(ne) , <(lt) , >(gt) , <=(le) , >=(ge) ==> true/false
         3) ��������
             && (and), || (or) ==> true/false
         4) ���׿����� 
                            ����:��1:��2 => ����(��) ��1,����(����) ��2
         5) empty 
 --%>
<%
    String pwd=request.getParameter("pwd");
    //${param.pwd}
    String name="ȫ�浿";
    //1.request�� ���� 
    request.setAttribute("name1",name);
    //2.session�� ����  
    session.setAttribute("id", "admin");
    // ${sessionScope.id}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <center>
   <b>${name1 }</b><br>
   ${requestScope.name1 }<br>
   <%= request.getAttribute("name1") %><br>
   ${sessionScope.id }<br>
   <%=session.getAttribute("id") %>
   <br>
   PWD:${param.pwd }
   <%=request.getParameter("pwd")%>
 </center>
</body>
</html>



<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
     String pwd=request.getParameter("pwd");
     String no=request.getParameter("no");
     String strPage=request.getParameter("page");
     // DB���� 
     boolean bCheck=true;
     if(bCheck==true)
     {
    	 response.sendRedirect("list.jsp?page="+strPage);
     }
     else
     {
%>
         <script type="text/javascript">
         alert("��й�ȣ�� Ʋ���ϴ�");
         history.back();
         </script>
<%
     }
%>


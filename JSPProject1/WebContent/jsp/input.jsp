<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
		request.setCharacterEncoding("EUC-KR");
		String name=request.getParameter("name");
		Strins name=request.getParameter("sex");
		String name=request.getParameter("tel1");
		String[] hobby name=request.getParameterValues("hobby");
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<center>
		<h3>���� ���� ����</h3>
		<form method=post action="output.jsp">
		<table border=1 wihth=380>
			<tr>
				<td width=25%>�̸�</td>
				<td width=75% align=left>
					<input type=text name=name size=12>
				</td>
			</tr>
			<tr>
				<td width=25%>����</td>
				<td width=75% align=left>
					<input type="radio" name=sex value="����" checked>����
					<input type="radio" name=sex value="����" >����
				</td>
			</tr>
			<tr>
				<td width=25%>��ȭ��ȣ</td>
				<td width=75% align=left>
					<select name="tell">
					<option>010</option>
					<option>011</option>
					<option>017</option>
					</select>
					<input type=text name=tel2 size=17> --%>

					<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.js"></script>
<script type="text/javascript">

// window.onload (�������� ������)=function(){}
// $(document).ready(function(){})
/*
 *   JavaScript
 			�������� ==> ������(window)
 			                    ȭ�����(document).
 			                    �Է�â(form)	
 */
$(function(){
	$('#sendBtn').click(function(){
		var name=$('#name').val();
		if(name.trim()==""){
			alert("�̸��� �Է��ϼ���");
			$('#name').focus();
			return;
		}
		$('#frm').submit();
	});
});
</script>
</head>
<body>
   <center>
      <h3>���� ���� ����</h3>
      <form method=post action="output.jsp id="frm">
      <table border=1 width=400>
        <tr>
          <td width=25%>�̸�</td>
          <td width=75% align=left>
           <input type=text name=name size=12 id="name">
          </td>
        </tr>
        <tr>
          <td width=25%>����</td>
          <td width=75% align=left>
           <input type="radio" name=sex value="����" checked>����
           <input type="radio" name=sex value="����">����
          </td>
        </tr>
        <tr>
          <td width=25%>��ȭ��ȣ</td>
          <td width=75% align=left>
           <select name="tel1">
             <option>010</option>
             <option>011</option>
             <option>017</option>
           </select>
           <input type=text name=tel2 size=17>
          </td>
        </tr>
        <tr>
          <td width=25%>���</td>
          <td width=75% align=left>
           <input type="checkbox" name=hobby value=�>�
           <input type="checkbox" name=hobby value=����>����
           <input type="checkbox" name=hobby value=����>����
           <input type="checkbox" name=hobby value=���>���
           <input type="checkbox" name=hobby value=����>����
           
          </td>
        </tr>
        <tr>
          <td colspan="2" align=center>
           <input type=button value="����" id="sendBtn">
          </td>
        </tr>
      </table>
      </form>
      <!-- 
        form = input,select,textarea
       -->
   </center>
</body>
</html>





					
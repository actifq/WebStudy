<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.board.dao.*"%>
<%
    String strNo=request.getParameter("no");
    String strPage=request.getParameter("page");
    BoardDAO dao=new BoardDAO();
    BoardDTO d=dao.boardContentData(Integer.parseInt(strNo));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.js"></script>
<script type="text/javascript">
var i=0;
$(function(){
	$('#delBtn').click(function(){
		if(i==0)
		{
			$('#delTr').show();
			$('#delBtn').attr("src","image/btn_cancel.gif");
			i=1;
		}
		else
		{
			$('#delTr').hide();
			$('#delBtn').attr("src","image/btn_delete.gif");
			i=0;
		}
	});
	$('#delBtn1').click(function(){
		var pwd=$('#pwd').val();
		if(pwd.trim()=="")
		{
			$('#delTr').show();
			$('#pwd').focus();
			return;
		}
		$('#delfrm').submit();
	});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board.css">

</head>

<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR" 
	pageEncoding="EUC-KR" import="com.board.dao.*"
%>

<%
	String strNo = request.getParameter("no");
	String strPage = request.getParameter("page");
	BoardDAO dao=new BoardDAO();
	BoardDTO d=dao.boardContentData(Integer.parseInt(strNo));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.js"></script>
<script type="text/javascript">
	var i=0;
	$(function(){
		$('#delBtn').click(function(){
			if(i==0){
				$('#delTr').show();
				$('#delBtn').attr("src","image/btn_cancel.gif");
				
				i=1;
			}
			else{
				$('#delTr').hide();
				$('#delBtn').attr("src","image/btn_delete.gif");
				i=0;
			}				
		});
		
		$('delBtn1').click(function(){
			var pwd=$('#pwd').val();
			if(pwd.trin()==""){
				$('#delTr').show();
				$('#pwd').focus();
				return;
			}
			$('#delfrm').submit();
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="board.css">

</head> --%>
<%--
		
		get ���
		delete.jsp?pwd=&no=1&page=3 
				
		post ���
		pwd=&no=1&page=3
		
		GET���
		open("delete.jsp?pwd=&no=1&page=3","GET")
		send()
		
		POST���
		open("delete.jsp","POST")
		send(pwd=&no=1&page=3)
		
		pwd=&no=1&page=3 ==> pwd=""
		no=1&page=3			  ==> pwd=null
		
		getParameter("pwd");   ==> null
		getParameter("pwd");   ==> ����
		
		if(pwd==null || pwd.equeals(""))
		
		
		list.jsp				==> page null
		list.jsp?page=	==> page 
 --%>
<body>
	
	<center>
		<img src="image/qna.jpg" width=500height=50>
		<p>
		<table border=1 bordercolor="black" width=500 cellpadding="0"
			cellspacing="0">
			<tr height=27>
				<td width=20% align=center bgcolor=#ccccff>��ȣ</td>
				<td width=30% align=center><%=d.getNo()%></td>
				<td width=20% align=center bgcolor=#ccccff>��ȸ��</td>
				<td width=30% align=center><%=d.getRegdate().toString() %></td>
			</tr>

			<tr height=27>
				<td width=20% align=center bgcolor=#ccccff>�̸�</td>
				<td width=30% align=center><%=d.getName() %></td>
				<td width=20% align=center bgcolor=#ccccff>��ȸ��</td>
				<td width=30% align=center><%=d.getHit() %></td>
			</tr>

			<tr height=27>
				<td width=20% align=center bgcolor=#ccccff>����</td>
				<td width=30% align=left colspan="3"><%=d.getSubject() %></td>
			</tr>

			<tr>
				<td colspan="4" align="left" valign="top" height=200>
					<pre><%=d.getContent() %></pre>
				</td>
			</tr>



		</table>
  <table border=0 width=500>
      <tr>
        <td align="right">
         <a href="reply.jsp?no=<%=strNo%>&page=<%=strPage%>">
         <img src="image/btn_reply.gif" border=0></a>
         <img src="image/btn_modify.gif">
         <img src="image/btn_delete.gif" id="delBtn">
         <a href="list.jsp?page=<%=strPage%>">
         <img src="image/btn_list.gif" border=0></a>
        </td>
      </tr>
      <tr id="delTr" style="display:none">
        <td align="right">
        <form method=post action="delete.jsp" id="delfrm">
                   ��й�ȣ:<input type="password" name=pwd size=10 id="pwd">
        <input type="hidden" name=no value="<%=strNo%>">
        <input type="hidden" name=page value="<%=strPage%>">
        <input type=button value="����" id="delBtn1">
        </form>
        </td>
      </tr>
    </table>
  </center>
</body>
</html>

<%-- 		<table border=0 width=500>
			
			<tr>
				<td align="right">
				    <a href="reply.jsp?no=<%=strNo%>&page=<%=strPage%>">
				    <img src="image/btn_reply.gif" border=0>
				    </a>
					<img src="image/btn_modify.gif">
					 
					 <img src="image/btn_delete.gif" id="delBtn">
					 
					 <a href="list.jsp?page=<%=strPage%>">
					 <img src="image/btn_list.gif" border=0>
					 </a>
				</td>
			</tr>
			
			<tr id="delTr" style="display:none">
			<td align="right">
			
 			<form method=post action="delete.jsp" id="delfrm">
			��й�ȣ:
				<input type="password" name=pwd size=10 id="pwd">
				<input type="hidden" name=no value="<%=strNo%>">
				<input type="hidden" name=page value="<%=strPage%>">
				<input type="button" value="����" id="delBtn1">
			</form>
			</td>
			</tr>
			
		</table>
	</center>
</body>
</html>
 --%>


















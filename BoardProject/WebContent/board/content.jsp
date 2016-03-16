<%@ page language="java" contentType="text/html; charset=EUC-KR" 
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
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board.css">

</head>
<body>
	
	<center>
		<img src="image/qna.jpg" width=500height=50>
		<p>
		<table border=1 bordercolor="black" width=500 cellpadding="0"
			cellspacing="0">
			<tr height=27>
				<td width=20% align=center bgcolor=#ccccff>번호</td>
				<td width=30% align=center><%=d.getNo()%></td>
				<td width=20% align=center bgcolor=#ccccff>작성일</td>
				<td width=30% align=center><%=d.getRegdate().toString() %></td>
			</tr>

			<tr height=27>
				<td width=20% align=center bgcolor=#ccccff>이름</td>
				<td width=30% align=center><%=d.getName() %></td>
				<td width=20% align=center bgcolor=#ccccff>조회수</td>
				<td width=30% align=center><%=d.getHit() %></td>
			</tr>

			<tr height=27>
				<td width=20% align=center bgcolor=#ccccff>제목</td>
				<td width=30% align=left colspan="3"><%=d.getSubject() %></td>
			</tr>

			<tr>
				<td colspan="4" align="left" valign="top" height=200> <!-- td는 한줄문자형이고, pre는 엔터 그대로 나오는거 -->
					<pre><%=d.getContent() %></pre> <!-- preview 있는 그대로 출력해줭!! -->
				</td>
			</tr>



		</table>

		<table border=0 width=500>
			
			<tr>
				<td align="right">
				    <img src="image/btn_reply.gif">
					<img src="image/btn_modify.gif">
					 
					 <img src="image/btn_delete.gif" id="delBtn">
					 
					 <a href="list.jsp?page=<%=strPage%>">
					 <img src="image/btn_list.gif" border=0>
					 </a>
				</td>
			</tr>
			
			<tr id="delTr" style="display:none">
			<td align="right">
			비밀번호:
			<input type="password" name=pwd size=10>
			<input type="button" value="삭제">
			</td>
			</tr>
			
		</table>
	</center>
</body>
</html>



















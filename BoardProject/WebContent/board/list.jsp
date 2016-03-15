
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.*,com.board.dao.*, java.text.*"%>

<%
	BoardDAO dao=new BoardDAO();
	String strPage=request.getParameter("page");
	if(strPage==null){
		strPage="1";  }// list.jsp?page=1 기본으로 셋팅하고 들어감
		
	int curpage=Integer.parseInt(strPage);
		List<BoardDTO> list=dao.boardListData(curpage);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board.css">
</head>
<body>
	<center>
		<img src="image/qna.jpg" width=700 height=80>
		<p>
		<table border=0 width=700>
			<tr>
				<td align=left><img src="image/btn_write.gif"></td>
			</tr>
		</table>

		<table border=0 width=700>
			<tr bgcolor="#ccccff">
				<th width=10%>No</th>
				<th width=45%>제목</th>
				<th width=15%>이름</th>
				<th width=20%>작성일</th>
				<th width=10%>조회수</th>
			</tr>

			<!-- 데이터 출력 -->
			<%
			for(BoardDTO d:list){
			%>
			<tr>
				<td width=10% align=center><%=d.getNo() %></td>
				<td width=45% align=left>
					<%
					if(d.getGroup_tab()>0){
						for(int i=0;i<d.getGroup_tab();i++){
							out.println("&nbsp;&nbsp;");
						}
						%> <img src="image/icon_reply.gif"> <%
					}
				%> <%=d.getSubject() %>
				<%
				String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				String dbday=d.getRegdate().toString();
				if(today.equals(dbday))
				{
					%>
					<sup><img src="image/icon_new (2).gif"></sup>
				<%
				}
				%>
				</td>
				<td width=15% align=center><%=d.getName() %></td>
				<td width=20% align=center><%=d.getRegdate().toString() %></td>
				<td width=10% align=center><%=d.getHit() %></td>
			</tr>
			<%
		}
		%>

		</table>
		<hr width=700>
		<table border=0 width=700>
			<tr>
				<td align="left"><select name=fs>
						<option value="name">이름</option>
						<option value="subject">제목</option>
						<option value="content">내용</option>
				</select> <input type=text name=ss size=12> <input type="image"
					src="image/btn_search.gif"> <!-- image는 java의 버튼과비슷(이미지 파일로 링크걸수있음 -->
				</td>
				<td align="right"><img src="image/begin.gif"> <img
					src="image/prev.gif"> [1][2][3][4][5] <img
					src="image/next.gif"> <img src="image/end.gif">
					&nbsp;&nbsp;0 page / 0 pages</td>
			</tr>
		</table>
	</center>
</body>
</html>



























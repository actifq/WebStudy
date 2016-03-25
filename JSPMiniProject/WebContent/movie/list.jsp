<%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.movie.dao.*"%>
    
<jsp:useBean id="mgr" class="com.movie.dao.MovieManager"/>

<%
List<MovieDTO> list=mgr.movieAllData();
List<String> mRank=mgr.movieRank();
List<String> mReserve=mgr.movieReserve();
List<String> mBoxoffice=mgr.movieBoxoffice();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
	<center>
		<table id="table_content">
			<tr>
				<%
					for(MovieDTO d:list){
						%>
						<td>
						<a href="../main/main.jsp?mode=8&no=<%=d.getNo()%>">
						<img src="<%=d.getImage() %>" width=100 height=120 border=0>
						</a>
						</td>
						<%
					}
				%>
			</tr>

			<tr>
				<%
					for(MovieDTO d:list){
						%>
						<td class="tdcenter">
							<b><%=d.getTitle() %></b>					
						</td>
						<%
					}
				%>
			</tr>

			<tr>
				<%
					for(MovieDTO d:list){
						%>
						<td class="tdcenter">
							<%=d.getRegdata()%>					
						</td>
						<%
					}
				%>
			</tr>
			
			<tr>
				<%
					for(MovieDTO d:list){
						%>
						<td class="tdcenter">
							<font color="red">
							<%=d.getGrade()%>					
							</font>
						</td>
						<%
					}
				%>
			</tr>
			
		</table>
		
		<table border=0 width=600 cellpadding="0" cellspacing="0">
			<tr>
				<td align=left valign="top">
					<table id="table_content" width=250>
						<tr>
							<th>영화순위</th>
						</tr>
						<%
							for(String name:mRank){
						%>
							<tr>
								<td id="tdleft"><%=name %>
								 
								</td>
							</tr>
						<%
							}
						%>
					</table>
				</td>
				
				<td align=left valign="top">
					<table id="table_content" width=250>
						<tr>
							<th>영화예매</th>
						</tr>
						<%
							for(String name:mReserve){
						%>
							<tr>
								<td id="tdleft"><%=name %>
								 
								</td>
							</tr>
						<%
							}
						%>
					</table>
				</td>
				
				<td align=left valign="top">
					<table id="table_content" width=250>
						<tr>
							<th>박스오피스</th>
						</tr>
						<%
							for(String name:mBoxoffice){
						%>
							<tr>
								<td id="tdleft"><%=name %>
								 
								</td>
							</tr>
						<%
							}
						%>
					</table>
				</td>
			</tr> 
			
		</table>
	</center>
</body>
</html>







































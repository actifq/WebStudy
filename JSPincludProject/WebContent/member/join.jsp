<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/table.css">
</head>
<body>

	<center>
		<h3>회원가입</h3>
		<form>
		<table border=1 bordercolor="black" width=500 cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<table border=0 width=500>

						<tr>
							<td width=15% align=right>ID</td>
							<td width=85% align=left><input type=text name=id size=12 readonly>
								<input type="button" value="중복체크">
							</td>
						</tr>

						<tr>
							<td width=15% align=right>Password</td>
							<td width=85% align=left><input type=password name=pwd	size=12 required>
							 &nbsp; 재입력 
							 <input type=password name=pwd1 size=12  required>
						<tr>
							<td width=15% align=right>이름</td>
							<td width=85% align=left>
								<input type=text name=name size=12  required>
							</td>
						</tr>

						<tr>
							<td width=15% align=right>성별</td>
							<td width=85% align=left>
								<input type=radio name=sex value=남자 checked>남자
								<input type=radio name=sex value=여자>여자
							</td>
						</tr>
						
						<tr>
							<td width=15% align=right>생년월일</td>
							<td width=85% align=left>
								<input type=date name=birth size=20>
							</td>
						</tr>

						<tr>
							<td colspan="2" align=center>
								<input type="submit" value="가입">
								<input type="button" value="취소">
							</td>
						</tr>

					</table>
				</td>
			</tr>
		</table>
		</form>
	</center>

</body>
</html>


















<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <form method=post action="output2.jsp">
  이름:<input type=text name=name size=12><br>
 성별:<input type=radio name=sex value=남자>남자
    <input type=radio name=sex value=여자>여자<br>
 전화:<select name=tel1>
     <option>010</option>
     <option>011</option>
     <option>017</option>
    </select>
    <input type=text name=tel2 size=7>-
    <input type=text name=tel3 size=7><br>
    <input type=submit value=전송>
  </form>
</body>
</html>







<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
      EL (표현언어) => 브라우저 화면 출력 
      => 사용법  ${출력문}
         1) ${param.id} => request.getParameter("id");
         2) ${requestScope.id}
            request.getAttribute("id")
            => ${id}
         3) ${sessionScope.id}
            session.getAttribute("id")
      => 연산자 
         1) 산술연산자 
            + , - , * , / , %
            / => 결과값 실수형 
            ${ 10+10 } ==> 20
            ${ "10"+1} ==> Integer.parseInt("10")+1
                       ==> 11 
                       ==> 산술연산자는 산술만 처리 (문자열 결합((X))
            ${ null +1 } ==> null(0으로 변환) ==> 1
            ${ 5/2 } ==> 2.5
            ==> ${ 5 div 2 }
            ${ 5%2 } ==> 1
            ==> ${ 5 mod 2} ==> 1
         2) 비교연산자
            ==(eq),!=(ne) , <(lt) , >(gt) , <=(le) , >=(ge) ==> true/false
         3) 논리연산자
             && (and), || (or) ==> true/false
         4) 삼항연산자 
                            조건:값1:값2 => 조건(참) 값1,조건(거짓) 값2
         5) empty 
 --%>
<%
    String pwd=request.getParameter("pwd");
    //${param.pwd}
    String name="홍길동";
    //1.request에 저장 
    request.setAttribute("name1",name);
    //2.session에 저장  
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



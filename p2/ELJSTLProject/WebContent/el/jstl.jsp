<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
        <%@ taglib prefix="c" uri=""%>
         <c:~~>
        <%@ taglib prefix="core" uri=""%>
         <core:~~>
        core : 변수설정 ,제어문,URL
         *** 변수 설정 
         <c:set var="id" value="admin"/>
         => <%
                String id="admin";
                request.setAttribute("id",id);
            %>
                     화면 출력 : ${id}
         *** 제어문 
         1) for문
            for(int i=1;i<10;i++)
            <c:forEach var="i" begin="1" end="9" step="1">
              ${i}
            for(String msg:list)
            <c:forEach var="msg" items="list">
         2) if문
            <c:if test="조건문"> ==> else문이 없다 
                             출력물
            </c:if>
            if(조건문)
            {
                                  출력 
            }
         3) choose문 
            <c:choose>
              <c:when test="조건문">출력</c:when>
              <c:when test="조건문">출력</c:when>
              <c:when test="조건문">출력</c:when>
              <c:otherwise></c:otherwise>
            </c:choose>
         4) forTokens
            <c:forTokens var="data"
                  value="red,green,blue,black,yellow"
                  delims=",">
            StringTokenizer st=new StringTokenizer(data,",")
         => XML형식으로 만들어진다 
            ======
            1)대소문자 구분 
            2)속성값는 반드시 ""
            3)열고 닫는 태그가 명확  
        fmt : 날짜변환 
        <fmt:formatDate value="date" pattern="yyyy-MM-dd"/>
        => SimpleDateFormat("yyyy-MM-dd")
        fn  ==> String,Collection
        xml ==> 파싱 (DOM,SAX,마셀)
        sql ==> DAO
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <center>
    구구단<br>
  <%
      for(int i=1;i<=9;i++)
      {
  %>
         <%= 5+"*"+i+"="+5*i %><br>
  <%
      }
  %>
  JSTL이용한 구구단<br>
  <c:forEach var="i" begin="1" end="9" step="1">
    5*${ i }=${5*i }<br>
  </c:forEach>
  <%
      String[] names={"홍길동","심청이","춘향이","박문수","김두한"};
      for(String n:names)
      {
  %>
         <%=n %><br>
  <%
      }
  %>
  <c:set var="n" value="<%=names %>"/>
  <%--
        request.setAttribute("n",names)
   --%>
  <c:forEach var="name" items="${n }">
     ${name }<br>
  </c:forEach>
  <c:forEach var="i" begin="1" end="10">
    <c:if test="${i%2==0 }">
      ${i } <br>
      <c:out value="${i }"/>
    </c:if>
  </c:forEach><br>
  <%--
      int a=1;
  --%>
  <c:set var="a" value="4"/>
  <%--
        if(a==1)
        else if(a==2)
        else if(a==3)
        else
   --%>
  <c:choose>
    <c:when test="${a==1 }">red</c:when>
    <c:when test="${a==2 }">green</c:when>
    <c:when test="${a==3 }">blue</c:when>
    <c:otherwise>black</c:otherwise>
  </c:choose><br>
  <c:forTokens var="color" items="red,blue,green" delims=",">
    ${color }	
  </c:forTokens>
 </center>
</body>
</html>


























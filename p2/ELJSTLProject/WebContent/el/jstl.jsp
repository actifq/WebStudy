<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
        <%@ taglib prefix="c" uri=""%>
         <c:~~>
        <%@ taglib prefix="core" uri=""%>
         <core:~~>
        core : �������� ,���,URL
         *** ���� ���� 
         <c:set var="id" value="admin"/>
         => <%
                String id="admin";
                request.setAttribute("id",id);
            %>
                     ȭ�� ��� : ${id}
         *** ��� 
         1) for��
            for(int i=1;i<10;i++)
            <c:forEach var="i" begin="1" end="9" step="1">
              ${i}
            for(String msg:list)
            <c:forEach var="msg" items="list">
         2) if��
            <c:if test="���ǹ�"> ==> else���� ���� 
                             ��¹�
            </c:if>
            if(���ǹ�)
            {
                                  ��� 
            }
         3) choose�� 
            <c:choose>
              <c:when test="���ǹ�">���</c:when>
              <c:when test="���ǹ�">���</c:when>
              <c:when test="���ǹ�">���</c:when>
              <c:otherwise></c:otherwise>
            </c:choose>
         4) forTokens
            <c:forTokens var="data"
                  value="red,green,blue,black,yellow"
                  delims=",">
            StringTokenizer st=new StringTokenizer(data,",")
         => XML�������� ��������� 
            ======
            1)��ҹ��� ���� 
            2)�Ӽ����� �ݵ�� ""
            3)���� �ݴ� �±װ� ��Ȯ  
        fmt : ��¥��ȯ 
        <fmt:formatDate value="date" pattern="yyyy-MM-dd"/>
        => SimpleDateFormat("yyyy-MM-dd")
        fn  ==> String,Collection
        xml ==> �Ľ� (DOM,SAX,����)
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
    ������<br>
  <%
      for(int i=1;i<=9;i++)
      {
  %>
         <%= 5+"*"+i+"="+5*i %><br>
  <%
      }
  %>
  JSTL�̿��� ������<br>
  <c:forEach var="i" begin="1" end="9" step="1">
    5*${ i }=${5*i }<br>
  </c:forEach>
  <%
      String[] names={"ȫ�浿","��û��","������","�ڹ���","�����"};
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


























<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.board.dao.*"%>
<%
    // ������ (insert.jsp) �ޱ�
    request.setCharacterEncoding("EUC-KR");
    String name=request.getParameter("name");
    String subject=request.getParameter("subject");
    String content=request.getParameter("content");
    String pwd=request.getParameter("pwd");
    // DAO => ���� (����Ŭ�� ������ ����)
    // ��Ƽ� ���� (DTO)
    BoardDTO d=new BoardDTO();
    d.setName(name);
    d.setSubject(subject);
    d.setContent(content);
    d.setPwd(pwd);
    BoardDAO dao=new BoardDAO();
    dao.boardInsert(d);
    
    // �̵� (list.jsp)
    response.sendRedirect("list.jsp");
    
%>

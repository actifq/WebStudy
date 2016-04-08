package com.sist.board;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPBinding;

import org.springframework.http.HttpRequest;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.board.dao.*;
/*
 *     JSP => 요청  => content.do
 *     Model @RequestMapping()
 *     DB    
 *     JSP => 해당 JSP로 이동 
 */
@Controller("bc")
public class BoardController {
   @RequestMapping("list.do")
   public String boardListData(HttpServletRequest req)
   {
	   String page=req.getParameter("page");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=10;
	   int start=(curpage*rowSize)-(rowSize-1);
	   int end=curpage*rowSize;
	   Map map=new HashMap();
	   map.put("start", start);
	   map.put("end", end);
	   List<BoardVO> list=BoardDAO.boardAllData(map);
	   int totalpage=BoardDAO.boardTotalPage();
	   req.setAttribute("list", list);
	   req.setAttribute("curpage", curpage);
	   req.setAttribute("totalpage", totalpage);
	   return "freeboard/list.jsp";
   }
   @RequestMapping("content.do")
   public String boardContentData(HttpServletRequest req)
   {
	   String no=req.getParameter("no");
	   String page=req.getParameter("page");
	   // DB 연동 
	   BoardVO vo=BoardDAO.boardContentData(Integer.parseInt(no));
	   // 데이터 결과값 => jsp
	   req.setAttribute("no", no);
	   req.setAttribute("page", page);
	   req.setAttribute("vo", vo);
	   return "freeboard/content.jsp";
   }
   @RequestMapping("insert.do")
   public String boardInsert(HttpServletRequest req)
   {
	   return "freeboard/insert.jsp";
   }
   @RequestMapping("insert_ok.do")
   public String boardInsertOk(HttpServletRequest req)
   throws Exception
   {
	   req.setCharacterEncoding("EUC-KR");
	   String name=req.getParameter("name");
	   String subject=req.getParameter("subject");
	   String content=req.getParameter("content");
	   String pwd=req.getParameter("pwd");
	   BoardVO vo=new BoardVO();
	   vo.setName(name);
	   vo.setSubject(subject);
	   vo.setContent(content);
	   vo.setPwd(pwd);

	   // DB연동 
	   BoardDAO.boardInsert(vo);
	   return "index.jsp";
   }
   
   @RequestMapping("update.do")
   public String boardUpdate(HttpServletRequest req){
	   
	   String no=req.getParameter("no");
	   String page=req.getParameter("page");
	   BoardVO vo=BoardDAO.boardUpdate(Integer.parseInt(no)); 
	   req.setAttribute("page", page);
	   req.setAttribute("vo", vo);
	   return"freeboard/update.jsp";
   }
   
   @RequestMapping("update_ok.do")
   public String boardUpdateOk(HttpServletRequest req)
	   throws Exception
	   {
		   
	   req.setCharacterEncoding("EUC-KR");
	   
	   String no=req.getParameter("no");
	   String page=req.getParameter("page");
	   String name=req.getParameter("name");
	   String subject=req.getParameter("subject");
	   String content=req.getParameter("content");
	   String pwd=req.getParameter("pwd");
	   BoardVO vo=new BoardVO();
	   
	   vo.setNo(Integer.parseInt(no));
	   vo.setName(name);
	   vo.setSubject(subject);
	   vo.setContent(content);
	   vo.setPwd(pwd);
	   
	   //DB연동
	   boolean bCheck=BoardDAO.boardUpdateOk(vo);
	   req.setAttribute("bCheck", bCheck);
	   req.setAttribute("no", no);
	   req.setAttribute("page", page);
	   return "freeboard/update_ok.jsp";
	   }
   }






package com.sist.board;

import javax.servlet.http.HttpServletRequest;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.board.dao.*;

/*
 * JSP => ��û => content.do
 * 	Model @RequestMapping()
 * DB
 * JSP=> �ش� JSP�� �̵�
 * 
 * 
 */

@Controller("bc")
//Controller �� �ö� �͵鿡�� �޸𸮸� �Ҵ���
//Bean ����ϴ°Ͱ� ���� 
public class BoardController {

		@RequestMapping("list.do")
		public String boardListData(HttpServletRequest req){
			
			String page=req.getParameter("page");
			if(page==null)
				page="1";
				
			
			
			int curpage=Integer.parseInt(page);
			int rowSize=10;
			int start=(curpage*rowSize)-(rowSize-1);
			int end=curpage*rowSize;
			int totalpage=BoardDAO.boardTotalPage();
			
			Map map=new HashMap();
			map.put("start", start);
			map.put("end", end);			
			
			List<BoardVO> list=BoardDAO.boardAllData(map);
			
			req.setAttribute("list", list);
			req.setAttribute("curpage", curpage);
			req.setAttribute("totalpage", totalpage);		

			return "freeboard/list.jsp";
		}
		
		@RequestMapping("content.do")
		public String boardContentData(HttpServletRequest req){
			String no=req.getParameter("no");
			String page=req.getParameter("page");
			
			//DB ����
			BoardVO vo=BoardDAO.boardContentData(Integer.parseInt(no));
			
			// ������ ����� => jsp
			
			req.setAttribute("no", no);
			req.setAttribute("page", page);
			req.setAttribute("vo", vo);
			return "freeboard/content.jsp";
		}
		
		
		
	
}





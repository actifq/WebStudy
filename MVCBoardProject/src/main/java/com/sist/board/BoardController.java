package com.sist.board;

import javax.servlet.http.HttpServletRequest;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.board.dao.*;

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
			req.setAttribute("msg", "���뺸��");
			return "freeboard/content.jsp";
		}
		
		
	
}





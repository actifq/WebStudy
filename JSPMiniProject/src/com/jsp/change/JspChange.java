package com.jsp.change;

public class JspChange {
	private static String[] jsp={
			
			//0
			"default.jsp",
			"../member/join.jsp",
			"../member/joinyes.jsp",
			"../databoard/list.jsp",
			"../databoard/insert.jsp",
			
			//5
			"../databoard/content.jsp",
			"../databoard/update.jsp",
			"../movie/list.jsp",
			"../movie/detail.jsp"
			
			//10
		
	}; 
	public static String change(int no)
	{
		
		return jsp[no];
	}
}

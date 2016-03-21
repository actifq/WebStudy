package com.jsp.change;

public class jspChange {
	private static String[] jsp={
			"default.jsp",
			"../board/databoard_list.jsp"
	};
	
	public static String change(int no){
		return jsp[no];
	}
	
}

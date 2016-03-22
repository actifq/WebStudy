package com.jsp.change;

public class jspChange {
	private static String[] jsp={
			"default.jsp",
			"../member/join.jsp"
	};
	
	public static String change(int no){
		return jsp[no];
	}
	
}

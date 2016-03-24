package com.sist.test;

import java.sql.Connection;

public class MainClass {

	public static void main(String[] args) {
		try
		{
			Context c=new Context();
			MyDataSource ds=(MyDataSource)c.lookup("jdbc/oracle");
			Connection conn=ds.getConnection();
		}catch(Exception ex){}
	}

}

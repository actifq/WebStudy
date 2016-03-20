package board.dao;

import java.sql.*;
import java.util.*;

public class boardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:ORCL";
	
	public BoardDAO(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void getConnection(){
		public (getConnection)){
			try{
				
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
	}
	
}

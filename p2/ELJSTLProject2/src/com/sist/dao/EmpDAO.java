package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
public class EmpDAO {
   private static SqlSessionFactory ssf;
   static
   {
      try
      {
    	  Reader reader=Resources.getResourceAsReader("Config.xml");
    	  ssf=new SqlSessionFactoryBuilder().build(reader);
      }catch(Exception ex)
      {
    	  System.out.println(ex.getMessage());
      }
   }
   public static List<EmpDTO> empAllData()
   {
	   return ssf.openSession().selectList("empAllData");
   }
}

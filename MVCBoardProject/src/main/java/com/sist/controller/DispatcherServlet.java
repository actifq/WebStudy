package com.sist.controller;

import java.io.*;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;




public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebApplicationContext wc;
	private List<String> list=new ArrayList<String>();
	
	public void init(ServletConfig config) throws ServletException {
		
		//	path 가져오기 applicationContext.xml에 있는거
		//	왜 저기서 가져오냐면 만들어져있기 때문에 그냥 가져오는거
		//	지금은 쭉 만들고 있지만 스프링에는 이미 구현이 되어 있기 때문에 ..
		// 	지금은 원리를 파악하기 위해서 다 만들고 있음 !
		
		
		String path=config.getInitParameter("contextConfigLocation");
		//WebApplicationContext <==> HandlerMapping과 통신하며 Class 가져온다
		//클래스 관리자 --> 컨테이너
		// 우리가 만들고있는건 컴포넌트 	
		
		//클래스 여러개 묶어서 한번에 처리할때 인터페이스/추상클래스 씀
		
		wc=new WebApplicationContext(path);
		list=wc.getFileName();
		
	}
		

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
			
			String cmd=request.getRequestURI();
			cmd=cmd.substring(request.getContextPath().length()+1);
			
			for(String strCls:list){
				
				//메모리할당
				Class clsName=Class.forName(strCls);
				
				//클래스정보 읽어옴
				
				
				//com.sist.board.*java Controller 가 올라간 것들에만 메모리를 할당햄
				//Bean 사용하는것과 같음 
				
				
				if(clsName.isAnnotationPresent(Controller.class)==false)
					continue;

				Object obj = clsName.newInstance();

				Method[] methods = clsName.getDeclaredMethods();
				for (Method m : methods) {
					RequestMapping rm = m.getAnnotation(RequestMapping.class);
					
					if (rm.value().equals(cmd)) {
						
						String jsp = (String) m.invoke(obj, request);
						RequestDispatcher rd = request.getRequestDispatcher(jsp);
						rd.forward(request, response);
						return;
							
						}
					}
					
				
				
			}
			
		}catch(Exception ex){
			System.out.println("service():"+ex.getMessage());
		}
	
	}

}






/*
package com.sist.controller;

import java.io.*;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private WebApplicationContext wc;
    private List<String> list=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
		String path=config.getInitParameter("contextConfigLocation");
	    // WebApplicationContext <==> HandlerMapping (Class)
		wc=new WebApplicationContext(path);
		list=wc.getFileName();
		//list=wc.list;
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String cmd=request.getRequestURI();
			cmd=cmd.substring(request.getContextPath().length()+1);
			for(String strCls:list)
			{
				Class clsName=Class.forName(strCls);
				if(clsName.isAnnotationPresent(Controller.class)==false)
					continue;
				Object obj=clsName.newInstance();
				
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m:methods)
				{
					RequestMapping rm=m.getAnnotation(RequestMapping.class);
					if(rm.value().equals(cmd))
					{
						String jsp=(String)m.invoke(obj, request);
						RequestDispatcher rd=
								request.getRequestDispatcher(jsp);
						rd.forward(request, response);
						return;
					}
				}
			}
		}catch(Exception ex)
		{
			System.out.println("service():"+ex.getMessage());
		}
	}

}
*/








































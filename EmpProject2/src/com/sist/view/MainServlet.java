// 메인서블릿 분활 연습
// 서블릿 파일 하나 생성후에 자바 클래스 파일에다가 extends 부분만 복사 후 붙여 넣으면 자동으로 Servlet생성됨

package com.sist.view;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}

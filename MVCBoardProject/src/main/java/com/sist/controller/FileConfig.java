package com.sist.controller;

/*	들어오는 과정 정리 !!
 * 
 * Tomcat이 돌면서 Web.xml을 읽음
 * 읽으면서 DispatcherServlet이 메모리 할당
 * 메모리할당은 Tomcat에서 다 해줌 메모리 할당 해달라고 패키지 네임하고 값들을 넘김 (web.xml)
 */

// 메모리할당할때 package.className 

import java.util.*;
import java.io.*;


public class FileConfig {
	public static List<String> getFileName(String pack){
		
		List<String> list=new ArrayList<String>();
		
		try{
			
			String path="C:\\Users\\sist\\git\\22\\MVCBoardProject\\src\\main\\java\\";
			
			//경로명 바꾸기
			// \\\\com\\\\sist\\\\board 로 경로명 수정완료
			path=path+pack.replace('.', '\\');

			
			//디렉토리 읽어옴
			File dir=new File(path);
			//디렉토리에 있는 파일들 다 가져오기
			File[] files=dir.listFiles();
			
			//디렉토리빼고 파일만 가져옴

			for(File f:files){
				if(f.isFile()){
					//자바 파일이 아닌것들은 제외하기
					String name=f.getName();
					System.out.println(name);
					
					//확장자 읽어올 준비 .java
					String ext=name.substring(name.lastIndexOf('.')+1);
					
					//.java 파일 읽어옴
					if(ext.equals("java")){
						
						// com.sist.board.BoardController 형식으로 만들어야됨
						// ========== pack
						// com.sist.board.BoardController 완성 !
						String ff=pack+"."+name.substring(0,name.lastIndexOf('.'));
						System.out.println(ff);
						list.add(ff);
						
						//메모리할당할 수 있는 클래스는 다 모음!!!!
					}
					
				}
			}
			
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
}































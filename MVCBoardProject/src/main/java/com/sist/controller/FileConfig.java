package com.sist.controller;

/*	������ ���� ���� !!
 * 
 * Tomcat�� ���鼭 Web.xml�� ����
 * �����鼭 DispatcherServlet�� �޸� �Ҵ�
 * �޸��Ҵ��� Tomcat���� �� ���� �޸� �Ҵ� �ش޶�� ��Ű�� �����ϰ� ������ �ѱ� (web.xml)
 */

// �޸��Ҵ��Ҷ� package.className 

import java.util.*;
import java.io.*;


public class FileConfig {
	public static List<String> getFileName(String pack){
		
		List<String> list=new ArrayList<String>();
		
		try{
			
			String path="C:\\Users\\sist\\git\\22\\MVCBoardProject\\src\\main\\java\\";
			
			//��θ� �ٲٱ�
			// \\\\com\\\\sist\\\\board �� ��θ� �����Ϸ�
			path=path+pack.replace('.', '\\');

			
			//���丮 �о��
			File dir=new File(path);
			//���丮�� �ִ� ���ϵ� �� ��������
			File[] files=dir.listFiles();
			
			//���丮���� ���ϸ� ������

			for(File f:files){
				if(f.isFile()){
					//�ڹ� ������ �ƴѰ͵��� �����ϱ�
					String name=f.getName();
					System.out.println(name);
					
					//Ȯ���� �о�� �غ� .java
					String ext=name.substring(name.lastIndexOf('.')+1);
					
					//.java ���� �о��
					if(ext.equals("java")){
						
						// com.sist.board.BoardController �������� �����ߵ�
						// ========== pack
						// com.sist.board.BoardController �ϼ� !
						String ff=pack+"."+name.substring(0,name.lastIndexOf('.'));
						System.out.println(ff);
						list.add(ff);
						
						//�޸��Ҵ��� �� �ִ� Ŭ������ �� ����!!!!
					}
					
				}
			}
			
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
}































package com.sist.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;


public class HandlerMapping extends DefaultHandler{
	List<String> list=new ArrayList<String>();

	
	//어트리뷰트 속성값 가지고 있기 떄문에 스타트엘리멘트 씀

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	
		try{
			// 패키지 다 모우기
			// 모아서 WebApplicationContext.java 에 넘김
			if(qName.equals("context:component-scan")){
				String pack=attributes.getValue("base-package");
				list.add(pack);
			}
			
		}catch(Exception ex){
			
		}
	
	}
	
	
	
}

package com.sist.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;


public class HandlerMapping extends DefaultHandler{
	List<String> list=new ArrayList<String>();

	
	//��Ʈ����Ʈ �Ӽ��� ������ �ֱ� ������ ��ŸƮ������Ʈ ��

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	
		try{
			// ��Ű�� �� ����
			// ��Ƽ� WebApplicationContext.java �� �ѱ�
			if(qName.equals("context:component-scan")){
				String pack=attributes.getValue("base-package");
				list.add(pack);
			}
			
		}catch(Exception ex){
			
		}
	
	}
	
	
	
}

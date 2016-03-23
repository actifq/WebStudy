package com.sist.test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * XML 파싱해오는 방법 2가지 ==> DOM , SAX
 * 		
 * 		SAX ==> Simple API for XML
 *         한줄씩 읽어서 데이터를 가지고 온다 ==> 한줄씩 읽을때마다 메소드를 이용
 *         
 *         <?xml version="1.0"> startDocument()
 *         <root> startElement()
 *         	<a>aaa</a>
 *         	startElement() characters endElement()
 *         	<b>bbb</b>
 *         </root>
 * 
 */
import java.util.*;
public class MyDefaultHandler extends DefaultHandler{
	
	Map map=new HashMap();
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		try{
			if(qName.equals("Resource")){
				String driverName=attributes.getValue("driverName");
				String url=attributes.getValue("url");
				String username=attributes.getValue("username");
				String password=attributes.getValue("password");
				String type=attributes.getValue("type");
				String name=attributes.getValue("name");
			
				//type 메모리할당
				Class clsName=Class.forName(type);
				
				MyDataSource ds=(MyDataSource)clsName.newInstance();
				ds.setDriverClassName(driverName);
				ds.setDriverClassName(url);
				ds.setDriverClassName(username);
				ds.setDriverClassName(password);
				ds.setDriverClassName(type);
				ds.setDriverClassName(name);
				
				map.put(name, ds);
				
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}

		
}



































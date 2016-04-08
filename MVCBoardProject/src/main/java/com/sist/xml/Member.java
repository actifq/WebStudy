package com.sist.xml;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

import java.util.*;



@XmlRootElement
public class Member {
	private List<Memberlist> memberlist=new ArrayList<Memberlist>();

	public List<Memberlist> getMemberlist() {
		return memberlist;
	}
	
	@XmlElement
	public void setMemberlist(List<Memberlist> memberlist) {
		this.memberlist = memberlist;
	}
	
		
}

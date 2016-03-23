package com.bean;
/*
 *   Bean : 일반 자바 클래스 
 *    = DTO,DAO,Manager
 */
public class MemberBean {
   private String name;
   private String sex;
   private String tel1;
   private String tel2;
   private String tel3;
   private String tel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getTel() {
		return tel1+"-"+tel2+"-"+tel3;
	}
	
}


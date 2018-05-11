package com.zhyl.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "YLZH_USER")
public class User implements Serializable {
	
	private int uno;
	private String unum;//¹¤ºÅ,µÇÂ¼ÕËºÅ
	private String upwd;
	private String uname;
	private String udept;
	
	public User() {
		super();
	}
	public User(int uno, String unum, String upwd, String uname, String udept) {
		super();
		this.uno = uno;
		this.unum = unum;
		this.upwd = upwd;
		this.uname = uname;
		this.udept = udept;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USER")   
    @SequenceGenerator(name="SEQ_USER", sequenceName="SEQ_USER",allocationSize = 1)  
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getUnum() {
		return unum;
	}
	public void setUnum(String unum) {
		this.unum = unum;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUdept() {
		return udept;
	}
	public void setUdept(String udept) {
		this.udept = udept;
	}
	
	
}

package com.zhyl.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "YLZH_PRIVILEGE")
public class Privilege implements Serializable {

	private int pno;
	private String pname;
	public Privilege() {
		super();
	}
	public Privilege(int pno, String pname) {
		super();
		this.pno = pno;
		this.pname = pname;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PRIVILEGE")   
    @SequenceGenerator(name="SEQ_PRIVILEGE", sequenceName="SEQ_PRIVILEGE",allocationSize = 1)  
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
}

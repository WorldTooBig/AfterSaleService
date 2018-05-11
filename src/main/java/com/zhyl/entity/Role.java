package com.zhyl.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "YLZH_ROLE")
public class Role implements Serializable {
	
	private int rno;
	private String rname;
	public Role() {
		super();
	}
	public Role(int rno, String rname) {
		super();
		this.rno = rno;
		this.rname = rname;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ROLE")   
    @SequenceGenerator(name="SEQ_ROLE", sequenceName="SEQ_ROLE",allocationSize = 1)  
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
}

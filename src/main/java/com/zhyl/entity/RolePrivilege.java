package com.zhyl.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "YLZH_ROLEPRIVILEGE")
public class RolePrivilege implements Serializable {

	private int rpno;
	
	private Role role;
	private Privilege privilege;
	
	public RolePrivilege() {
		super();
	}
	public RolePrivilege(int rpno) {
		super();
		this.rpno = rpno;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ROLEPRIVILEGE")   
    @SequenceGenerator(name="SEQ_ROLEPRIVILEGE", sequenceName="SEQ_ROLEPRIVILEGE",allocationSize = 1) 
	public int getRpno() {
		return rpno;
	}
	public void setRpno(int rpno) {
		this.rpno = rpno;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name="rno")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name="pno")
	public Privilege getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
	
	
}

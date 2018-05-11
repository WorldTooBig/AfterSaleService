package com.zhyl.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "YLZH_USERROLE")
public class UserRole implements Serializable {

	private int urno;
	
	private User user;
	private Role role;
	
	public UserRole() {
		super();
	}

	public UserRole(int urno) {
		super();
		this.urno = urno;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USERROLE")   
    @SequenceGenerator(name="SEQ_USERROLE", sequenceName="SEQ_USERROLE",allocationSize = 1) 
	public int getUrno() {
		return urno;
	}

	public void setUrno(int urno) {
		this.urno = urno;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name="uno")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name="rno")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}

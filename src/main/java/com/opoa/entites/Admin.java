package com.opoa.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	private String mailId;
	private String password;

	//Mappings
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Order", cascade = CascadeType.ALL)
//	private List<Order> order= new ArrayList<>();


	
	public String getMailId() {
		return mailId;
	}
	
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [mailId=" + mailId + ", password=" + password + "]";
	}

	public Admin(String mailId, String password) {
		super();
		this.mailId = mailId;
		this.password = password;
	}

	public Admin() {
		super();
	}

}
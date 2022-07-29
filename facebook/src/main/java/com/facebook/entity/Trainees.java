package com.facebook.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trainees {
	@Id
	private String tr_id;
	private String tr_name;
	private String tr_address;
	private String email;
	
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Trainer tt;

	public String getTr_id() {
		return tr_id;
	}

	public void setTr_id(String tr_id) {
		this.tr_id = tr_id;
	}

	public String getTr_name() {
		return tr_name;
	}

	public void setTr_name(String tr_name) {
		this.tr_name = tr_name;
	}

	public String getTr_address() {
		return tr_address;
	}

	public void setTr_address(String tr_address) {
		this.tr_address = tr_address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Trainer getTt() {
		return tt;
	}

	public void setTt(Trainer tt) {
		this.tt = tt;
	}
	
	
	
}

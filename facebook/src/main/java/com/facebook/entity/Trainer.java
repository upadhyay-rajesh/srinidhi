package com.facebook.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer {
	
	@Id
	private long t_id;
	private String t_name;
	private String t_address;
	private String t_skill;
	
	@OneToMany(mappedBy = "tt")
	private List<Trainees> tList;

	public long getT_id() {
		return t_id;
	}

	public void setT_id(long t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_address() {
		return t_address;
	}

	public void setT_address(String t_address) {
		this.t_address = t_address;
	}

	public String getT_skill() {
		return t_skill;
	}

	public void setT_skill(String t_skill) {
		this.t_skill = t_skill;
	}

	public List<Trainees> gettList() {
		return tList;
	}

	public void settList(List<Trainees> tList) {
		this.tList = tList;
	}
	
	
	
	

}

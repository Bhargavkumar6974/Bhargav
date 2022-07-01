package com.pro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Warden {

	@Id
	@OneToMany
	private int warden_id;

	@Column(nullable = false)
	private String warden_name;

	@Column(nullable = false)
	private int warden_floor;
	private int warden_contact;

	public int getWarden_id() {
		return warden_id;
	}

	public void setWarden_id(int warden_id) {
		this.warden_id = warden_id;
	}

	public String getWarden_name() {
		return warden_name;
	}

	public void setWarden_name(String warden_name) {
		this.warden_name = warden_name;
	}

	public int getWarden_floor() {
		return warden_floor;
	}

	public void setWarden_floor(int warden_floor) {
		this.warden_floor = warden_floor;
	}

	public int getWarden_contact() {
		return warden_contact;
	}

	public void setWarden_contact(int warden_contact) {
		this.warden_contact = warden_contact;
	}

	public Warden(int warden_id, String warden_name, int warden_floor, int warden_contact) {
		super();
		this.warden_id = warden_id;
		this.warden_name = warden_name;
		this.warden_floor = warden_floor;
		this.warden_contact = warden_contact;
	}

	public Warden() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Warden [warden_id=" + warden_id + ", warden_name=" + warden_name + ", warden_floor=" + warden_floor
				+ ", warden_contact=" + warden_contact + "]";
	}

}

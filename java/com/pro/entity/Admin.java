package com.pro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private int admin_id;
	private int hostel_id;

	@Column
	private int admin_name;
	private int admin_contact;

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public int getHostel_id() {
		return hostel_id;
	}

	public void setHostel_id(int hostel_id) {
		this.hostel_id = hostel_id;
	}

	public int getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(int admin_name) {
		this.admin_name = admin_name;
	}

	public int getAdmin_contact() {
		return admin_contact;
	}

	public void setAdmin_contact(int admin_contact) {
		this.admin_contact = admin_contact;
	}

	public Admin(int admin_id, int hostel_id, int admin_name, int admin_contact) {
		super();
		this.admin_id = admin_id;
		this.hostel_id = hostel_id;
		this.admin_name = admin_name;
		this.admin_contact = admin_contact;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", hostel_id=" + hostel_id + ", admin_name=" + admin_name
				+ ", admin_contact=" + admin_contact + "]";
	}

}

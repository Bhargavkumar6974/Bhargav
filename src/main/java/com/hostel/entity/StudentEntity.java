package com.hostel.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import lombok.Builder;

@Entity
@Builder
public class StudentEntity {

	@Id
	private int student_id;

	
	private String student_name;
	private int student_contact;
	private int student_room_id;
	private int student_floor_id;

	
	private int warden_id;

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getStudent_contact() {
		return student_contact;
	}

	public void setStudent_contact(int student_contact) {
		this.student_contact = student_contact;
	}

	public int getStudent_room_id() {
		return student_room_id;
	}

	public void setStudent_room_id(int student_room_id) {
		this.student_room_id = student_room_id;
	}

	public int getStudent_floor_id() {
		return student_floor_id;
	}

	public void setStudent_floor_id(int student_floor_id) {
		this.student_floor_id = student_floor_id;
	}

	public int getWarden_id() {
		return warden_id;
	}

	public void setWarden_id(int warden_id) {
		this.warden_id = warden_id;
	}

	public StudentEntity(int student_id, String student_name, int student_contact, int student_room_id, int student_floor_id,
			int warden_id) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_contact = student_contact;
		this.student_room_id = student_room_id;
		this.student_floor_id = student_floor_id;
		this.warden_id = warden_id;
	}

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_contact="
				+ student_contact + ", student_room_id=" + student_room_id + ", student_floor_id=" + student_floor_id
				+ ", warden_id=" + warden_id + "]";
	}

	/*
	 * @JoinTable(name = "STUDENT_ROOM", joinColumns = @JoinColumn
	 * (name="STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "ROOM_ID"))
	 */

}

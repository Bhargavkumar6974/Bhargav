package com.hostel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;

@Entity
@Builder
public class FloorEntity {

	@Id
	private int floor_id;

	private int hostel_id;
	private int warden_id;

	@Column
//	private int no_of_students;
	private int no_of_rooms;

	public int getHostel_id() {
		return hostel_id;
	}

	public void setHostel_id(int hostel_id) {
		this.hostel_id = hostel_id;
	}

	public int getWarden_id() {
		return warden_id;
	}

	public void setWarden_id(int warden_id) {
		this.warden_id = warden_id;
	}

	public int getFloor_id() {
		return floor_id;
	}

	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}

//	public int getNo_of_students() {
//		return no_of_students;
//	}
//	public void setNo_of_students(int no_of_students) {
//		this.no_of_students = no_of_students;
//	}
	public int getNo_of_rooms() {
		return no_of_rooms;
	}

	public void setNo_of_rooms(int no_of_rooms) {
		this.no_of_rooms = no_of_rooms;
	}

	public FloorEntity(int hostel_id, int warden_id, int floor_id, int no_of_rooms) {
		super();
		this.hostel_id = hostel_id;
		this.warden_id = warden_id;
		this.floor_id = floor_id;
		// this.no_of_students = no_of_students;
		this.no_of_rooms = no_of_rooms;
	}

	public FloorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FloorEntity [floor_id=" + floor_id + ", hostel_id=" + hostel_id + ", warden_id=" + warden_id
				+ ", no_of_rooms=" + no_of_rooms + "]";
	}

}

package com.pro.payload;

public class HostelDto {

	private int hostel_id;

	private String hostel_name;
	private String hostel_admin;

	private int no_of_floors;

	private int no_of_student;
	private int no_of_wardens;

	public int getHostel_id() {
		return hostel_id;
	}

	public void setHostel_id(int hostel_id) {
		this.hostel_id = hostel_id;
	}

	public String getHostel_name() {
		return hostel_name;
	}

	public void setHostel_name(String hostel_name) {
		this.hostel_name = hostel_name;
	}

	public String getHostel_admin() {
		return hostel_admin;
	}

	public void setHostel_admin(String hostel_admin) {
		this.hostel_admin = hostel_admin;
	}

	public int getNo_of_floors() {
		return no_of_floors;
	}

	public void setNo_of_floors(int no_of_floors) {
		this.no_of_floors = no_of_floors;
	}

	public int getNo_of_student() {
		return no_of_student;
	}

	public void setNo_of_student(int no_of_student) {
		this.no_of_student = no_of_student;
	}

	public int getNo_of_wardens() {
		return no_of_wardens;
	}

	public void setNo_of_wardens(int no_of_wardens) {
		this.no_of_wardens = no_of_wardens;
	}

	public HostelDto(int hostel_id, String hostel_name, String hostel_admin, int no_of_floors, int no_of_student,
			int no_of_wardens) {
		super();
		this.hostel_id = hostel_id;
		this.hostel_name = hostel_name;
		this.hostel_admin = hostel_admin;
		this.no_of_floors = no_of_floors;
		this.no_of_student = no_of_student;
		this.no_of_wardens = no_of_wardens;
	}

	public HostelDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Hostel [hostel_id=" + hostel_id + ", hostel_name=" + hostel_name + ", hostel_admin=" + hostel_admin
				+ ", no_of_floors=" + no_of_floors + ", no_of_student=" + no_of_student + ", no_of_wardens="
				+ no_of_wardens + "]";
	}

}

package com.pro.service;

import java.util.List;

import com.pro.payload.StudentDto;

public interface StudentSer {

	public StudentDto createStudent(StudentDto studentDto);

	

	StudentDto updateStudentById(StudentDto StudentDto, int student_id);

	List<StudentDto> getStudents();

	StudentDto getStudentById(int student_id);

	void deleteStudentById(int student_id);
}

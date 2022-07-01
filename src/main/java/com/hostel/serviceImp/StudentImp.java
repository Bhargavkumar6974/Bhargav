package com.hostel.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.entity.StudentEntity;
import com.hostel.exceptions.ResourceNotFoundException;
import com.hostel.payload.StudentDto;
import com.hostel.repo.StudentRepository;
import com.hostel.service.StudentSer;

@Service
public class StudentImp implements StudentSer {

	@Autowired

	private StudentRepository studentRepo;

	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		StudentEntity student = this.studentDtoToStudent(studentDto);
		StudentEntity saveStudent = this.studentRepo.save(student);
		return this.studentToStudentDto(saveStudent);
	}
	
	@Override
	public List<StudentDto> getStudents() {
		List<StudentEntity> studentRecordsEntity = this.studentRepo.findAll();
		List<StudentDto> studentRecordsDto = studentRecordsEntity.stream().map(student1 -> this.studentToStudentDto(student1))
				.collect(Collectors.toList());
		return studentRecordsDto;

	}

	@Override
	public StudentDto getStudentById(int student_id) {
		StudentEntity student=this.studentRepo.findById(student_id).orElseThrow(
				()->new ResourceNotFoundException("student","studentId",student_id));
		return this.studentToStudentDto(student); //dto for fetching
	}

	@Override
	public StudentDto updateStudentById(StudentDto studentDto, int student_id) {
		StudentEntity student=this.studentRepo.findById(student_id).orElseThrow(()-> new ResourceNotFoundException("student","Student_id",student_id));
		student.setStudent_id(studentDto.getStudent_id());
		student.setStudent_name(studentDto.getStudent_name());
		student.setStudent_contact(studentDto.getStudent_contact());
		student.setStudent_room_id(studentDto.getStudent_room_id());
		student.setStudent_floor_id(studentDto.getStudent_floor_id());
		student.setWarden_id(studentDto.getWarden_id());
		this.studentRepo.save(student);
		return this.studentToStudentDto(student);
	}

	@Override
	public void deleteStudentById(int student_id) {
	  StudentEntity student=this.studentRepo.findById(student_id).orElseThrow(
			  ()->new ResourceNotFoundException("student","studentId",student_id));
		this.studentRepo.delete(student);
	}



	private StudentDto studentToStudentDto(StudentEntity student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setStudent_id(student.getStudent_id());
		studentDto.setStudent_name(student.getStudent_name());
		studentDto.setStudent_contact(student.getStudent_contact());
		studentDto.setStudent_room_id(student.getStudent_room_id());
		studentDto.setStudent_floor_id(student.getStudent_floor_id());
		studentDto.setWarden_id(student.getWarden_id());
		return studentDto;
	}

	private StudentEntity studentDtoToStudent(StudentDto studentDto) {
		StudentEntity student = new StudentEntity();
		student.setStudent_id(studentDto.getStudent_id());
		student.setStudent_name(studentDto.getStudent_name());
		student.setStudent_contact(studentDto.getStudent_contact());
		student.setStudent_room_id(studentDto.getStudent_room_id());
		student.setStudent_floor_id(studentDto.getStudent_floor_id());
		student.setWarden_id(studentDto.getWarden_id());

		return student;
	}

}
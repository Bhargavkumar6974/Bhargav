package com.hostel.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostel.exceptions.ApiResponse;
import com.hostel.payload.StudentDto;
import com.hostel.service.StudentSer;



@RestController
@RequestMapping("/api")
public class StudentControler {

	@Autowired
	private StudentSer studentSer;
    
	@PostMapping("/studentCreate")
	public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto student)
	{
		StudentDto createStudent=this.studentSer.createStudent(student);
		return new ResponseEntity<StudentDto>(createStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("/studentGet")
	public ResponseEntity<List<StudentDto>> getStudents()
	{
		List<StudentDto> allStudents=this.studentSer.getStudents();
		return new ResponseEntity<List<StudentDto>>(allStudents,HttpStatus.OK);
	}
	
	@GetMapping("/student/{student_id}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable int student_id)
	{
		StudentDto studentDto=this.studentSer.getStudentById(student_id);
		return new ResponseEntity<StudentDto>(studentDto,HttpStatus.OK);
	}
	
	@PutMapping("/studentUpdate/{student_id}")
	public ResponseEntity<StudentDto> updateStudentById(@RequestBody StudentDto student,@PathVariable int student_id)
	{
		StudentDto studentDto=this.studentSer.updateStudentById(student, student_id);
		return new ResponseEntity<StudentDto>(studentDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/student/{student_id}")
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable int student_id)
	{
		this.studentSer.deleteStudentById(student_id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User record is deleted successfully",true),HttpStatus.OK);
		
	}
	
	
}


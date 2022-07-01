
package com.hostel.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.Column;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.hostel.entity.StudentEntity;
import com.hostel.repo.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StudentRepositoryTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Autowired
	private StudentRepository studentRepository;

	@Test
	@Order(1)
	// @Rollback(value = false)
	public void saveStudentTest() {
		StudentEntity student = StudentEntity.builder()

				.student_name("raju").student_contact(65864765).build();

		studentRepository.save(student);

		// Assertions.assertThat(student.getStudent_id()).isGreaterThan(0);

	}

	@Test
	@Order(2)
	// @Rollback(value = false)
	public void getStudentId() {

		StudentEntity student = studentRepository.findById(10).get();
		Assertions.assertThat(student.getStudent_id()).isEqualTo(10);
	}

	@Test
	@Order(3)
//			@Rollback(value = false)
	public void getAllStudents() {
		List<StudentEntity> student = this.studentRepository.findAll();

		Assertions.assertThat(student.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	// @Rollback(value = false)
	public void updateStudentTest() {

		StudentEntity student = studentRepository.findById(10).get();
		student.setStudent_contact(65864765);
		StudentEntity user1 = studentRepository.save(student);
		Assertions.assertThat(user1.getStudent_contact()).isEqualTo(65864765);

	}

}

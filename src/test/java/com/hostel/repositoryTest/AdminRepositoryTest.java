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

import com.hostel.entity.AdminEntity;
import com.hostel.repo.AdminRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class AdminRepositoryTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Autowired
	private AdminRepository adminRepository;

	@Test
	@Order(1)
	// @Rollback(value = false)
	public void saveAdminTest() {
		AdminEntity admin = AdminEntity.builder()

				.admin_name("ravi reddy").admin_contact(6545245).build();

		adminRepository.save(admin);

		Assertions.assertThat(admin.getAdmin_id()).isGreaterThan(0);

	}

	@Test
	@Order(2)
	// @Rollback(value = false)
	public void getAdminId() {

		AdminEntity admin = adminRepository.findById(1).get();
		Assertions.assertThat(admin.getAdmin_id()).isEqualTo(1);
	}

	@Test
	@Order(3)
//		@Rollback(value = false)
	public void getAllAdmins() {
		List<AdminEntity> admin = this.adminRepository.findAll();

		Assertions.assertThat(admin.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	// @Rollback(value = false)
	public void updateAdminTest() {

		AdminEntity admin = adminRepository.findById(1).get();
		admin.setAdmin_contact(32535445);
		AdminEntity user1 = adminRepository.save(admin);
		Assertions.assertThat(user1.getAdmin_contact()).isEqualTo(32535445);

	}

}

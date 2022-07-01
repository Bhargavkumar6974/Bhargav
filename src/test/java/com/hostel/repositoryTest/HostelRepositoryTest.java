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

import com.hostel.entity.HostelEntity;
import com.hostel.repo.HostelRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class HostelRepositoryTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Autowired
	private HostelRepository hostelRepository;

	@Test
	@Order(1)
	// @Rollback(value = false)
	public void saveHostelTest() {
		HostelEntity hostel = HostelEntity.builder()

				.no_of_floors(6).hostel_name("narayana").build();

		hostelRepository.save(hostel);

		Assertions.assertThat(hostel.getNo_of_floors()).isGreaterThan(0);

	}

	@Test
	@Order(2)
	// @Rollback(value = false)
	public void getHostelId() {

		HostelEntity hostel = hostelRepository.findById(9).get();
		Assertions.assertThat(hostel.getHostel_id()).isEqualTo(9);
	}

	@Test
	@Order(3)
//			@Rollback(value = false)
	public void getAllHostels() {
		List<HostelEntity> hostel = this.hostelRepository.findAll();

		Assertions.assertThat(hostel.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	// @Rollback(value = false)
	public void updateHostelTest() {

		HostelEntity hostel = hostelRepository.findById(9).get();
		hostel.setNo_of_floors(6);
		HostelEntity user1 = hostelRepository.save(hostel);
		Assertions.assertThat(user1.getNo_of_floors()).isEqualTo(6);

	}

}

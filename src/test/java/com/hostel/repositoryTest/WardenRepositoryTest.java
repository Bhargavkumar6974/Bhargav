
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

import com.hostel.entity.WardenEntity;
import com.hostel.repo.WardenRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class WardenRepositoryTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Autowired
	private WardenRepository wardenRepository;

	@Test
	@Order(1)
	// @Rollback(value = false)
	public void saveWardenTest() {
		WardenEntity warden = WardenEntity.builder()

				.warden_name("ramya").warden_contact(94515245).build();

		wardenRepository.save(warden);

		// Assertions.assertThat(warden.getWarden_id()).isGreaterThan(0);

	}

	@Test
	@Order(2)
	// @Rollback(value = false)
	public void getWardenId() {

		WardenEntity warden = wardenRepository.findById(62).get();
		Assertions.assertThat(warden.getWarden_id()).isEqualTo(62);
	}

	@Test
	@Order(3)
//			@Rollback(value = false)
	public void getAllWardens() {
		List<WardenEntity> warden = this.wardenRepository.findAll();

		Assertions.assertThat(warden.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	// @Rollback(value = false)
	public void updateWardenTest() {

		WardenEntity warden = wardenRepository.findById(62).get();
		warden.setWarden_contact(94515245);
		WardenEntity user1 = wardenRepository.save(warden);
		Assertions.assertThat(user1.getWarden_contact()).isEqualTo(94515245);

	}

}

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

import com.hostel.entity.FloorEntity;
import com.hostel.repo.FloorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class FloorRepositoryTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Autowired
	private FloorRepository floorRepository;

	@Test
	@Order(1)
	// @Rollback(value = false)
	public void saveFloorTest() {
		FloorEntity floor = FloorEntity.builder().no_of_rooms(10).build();

		floorRepository.save(floor);
		Assertions.assertThat(floor.getNo_of_rooms()).isEqualTo(10);

//			Assertions.assertThat(floor.getFloor_id()).isGreaterThan(0);

	}

	@Test
	@Order(2)
	// @Rollback(value = false)
	public void getFloorId() {

		FloorEntity floor = floorRepository.findById(1).get();
		Assertions.assertThat(floor.getFloor_id()).isEqualTo(1);
	}

	@Test
	@Order(3)
//			@Rollback(value = false)
	public void getAllFloors() {
		List<FloorEntity> floor = this.floorRepository.findAll();

		Assertions.assertThat(floor.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	// @Rollback(value = false)
	public void updateFloorTest() {
		FloorEntity floor = floorRepository.findById(1).get();
		floor.setNo_of_rooms(11);
		FloorEntity floor1 = floorRepository.save(floor);
		Assertions.assertThat(floor1.getNo_of_rooms()).isEqualTo(11);

	}

}

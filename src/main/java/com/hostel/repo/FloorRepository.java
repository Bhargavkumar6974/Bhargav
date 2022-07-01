package com.hostel.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostel.entity.FloorEntity;


@Repository
public interface FloorRepository extends JpaRepository<FloorEntity,Integer> {

}

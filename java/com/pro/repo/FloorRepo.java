package com.pro.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.entity.Floor;


@Repository
public interface FloorRepo extends JpaRepository<Floor,Integer> {

}

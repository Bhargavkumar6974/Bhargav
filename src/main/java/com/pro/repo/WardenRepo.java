package com.pro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pro.entity.Warden;

@Repository
public interface WardenRepo extends JpaRepository<Warden,Integer> {

}


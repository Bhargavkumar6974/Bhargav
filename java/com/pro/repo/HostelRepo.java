package com.pro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.entity.Hostel;



@Repository
public interface HostelRepo extends JpaRepository<Hostel,Integer> {

}


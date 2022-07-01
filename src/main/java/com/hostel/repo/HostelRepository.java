package com.hostel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostel.entity.HostelEntity;



@Repository
public interface HostelRepository extends JpaRepository<HostelEntity,Integer> {

}


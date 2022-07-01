package com.hostel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostel.entity.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Integer> {

}

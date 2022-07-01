package com.pro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {

}

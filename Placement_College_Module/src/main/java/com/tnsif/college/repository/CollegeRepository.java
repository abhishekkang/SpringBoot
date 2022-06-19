package com.tnsif.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.college.model.College;

public interface CollegeRepository extends JpaRepository<College, Integer> {

}

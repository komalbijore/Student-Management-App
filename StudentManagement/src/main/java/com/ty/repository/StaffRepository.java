package com.ty.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{

	Optional<Staff> findByEmail(String email);
}

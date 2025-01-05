package com.ty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}

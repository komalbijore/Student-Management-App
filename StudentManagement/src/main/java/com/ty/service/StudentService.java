package com.ty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.entity.Student;
import com.ty.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	public List<Student> getAll() {
		return repository.findAll();
	}

	public Student save(Student student) {
		return repository.save(student);
	}

	public Student getById(Integer sid) {
		return repository.findById(sid).get();
	}

	public void deleteById(Integer sid) {
		repository.deleteById(sid);
	}

}

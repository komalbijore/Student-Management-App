package com.ty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.entity.Staff;
import com.ty.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;

	public boolean register(Staff staff) {
		Optional<Staff> opt = staffRepository.findByEmail(staff.getEmail());

		if (opt.isPresent()) {
			return false;
		} else {
			staffRepository.save(staff);
			return true;
		}

	}

	public boolean login(String email, String password) {
		Optional<Staff> opt = staffRepository.findByEmail(email);
		if (opt.isPresent()) {
			if (opt.get().getPassword().equals(password)) {
				return true;
			}
			return false;
		}
		return false;
	}

}

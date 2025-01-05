package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dto.EmailDto;
import com.ty.entity.Staff;
import com.ty.entity.Student;
import com.ty.service.EmailService;
import com.ty.service.StaffService;
import com.ty.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class StudentController {

	@Autowired
	private StaffService staffService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private EmailService emailService;

	@GetMapping("/")
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("staff", new Staff());
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@PostMapping("/register")
	public ModelAndView registerStaff(Staff staff) {
		boolean result = staffService.register(staff);
		ModelAndView mv = new ModelAndView();
		if (result) {
			mv.setViewName("login");
			mv.addObject("msg", "Registered Successfully");
		} else {
			mv.setViewName("register");
			mv.addObject("msg", "already registered");
		}

		return mv;
	}

	@PostMapping("/login")
	public ModelAndView loginPage(HttpServletRequest request) {

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		boolean result = staffService.login(email, password);
		ModelAndView mv = new ModelAndView();
		if (result) {
			List<Student> all = studentService.getAll();
			mv.setViewName("home");
			mv.addObject("students", all);
			mv.addObject("msg", "Welcome to App");
		} else {
			mv.setViewName("login");
			mv.addObject("msg", "Invalid credentials");
		}

		return mv;
	}

	@GetMapping("/home")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.getAll();
		mv.addObject("students", all);
		return mv;
	}

	@GetMapping("/add")
	public ModelAndView studentPage() {
		ModelAndView mv = new ModelAndView("student");
		mv.addObject("stu", new Student());
		return mv;
	}

	@PostMapping("/save")
	public ModelAndView saveStudent(Student student) {
		Student save = studentService.save(student);
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.getAll();
		mv.addObject("students", all);
		if (save != null) {
			mv.addObject("msg", "Student added");
		} else {
			mv.addObject("msg", "something went wrong");
		}
		return mv;
	}

	@GetMapping("/email")
	public ModelAndView dispEmail() {
		ModelAndView mv = new ModelAndView("email");
		mv.addObject("emaildto", new EmailDto());
		return mv;
	}

	@PostMapping("/send")
	public ModelAndView sendEmail(EmailDto dto) {
		emailService.send(dto);
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.getAll();
		mv.addObject("students", all);
		mv.addObject("msg", "Mail sent");
		return mv;
	}
	
	@GetMapping("/update")
	public ModelAndView updateStudent(@RequestParam Integer sid) {
		Student student = studentService.getById(sid);
		ModelAndView mv=new ModelAndView("update");
		mv.addObject("stu", student);
		return mv;
	}
	
	@PostMapping("/update")
	public ModelAndView updateStudent(Student student) {
		studentService.save(student);
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.getAll();
		mv.addObject("students", all);
		mv.addObject("msg", "Updated");
		return mv;
	}
	
	@GetMapping("/delete")
	public ModelAndView deletStudent(@RequestParam Integer sid) {
		studentService.deleteById(sid);
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.getAll();
		mv.addObject("students", all);
		mv.addObject("msg", "Deleted");
		return mv;
	}
	

}

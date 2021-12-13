package com.amin.controller;

import com.amin.model.Student;
import com.amin.model.StudentRepository;
import com.amin.model.SubjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	private final StudentRepository student;
	private final SubjectRepository subjectRepository;


	public AdminController(StudentRepository student, SubjectRepository subjectRepository) {
		this.student = student;
		this.subjectRepository = subjectRepository;
	}


	@GetMapping("/adminsearch")
	public String adadmin(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("subjects", subjectRepository.findAll());
		return "addstudent";
	}
	


	

}

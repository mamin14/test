package com.amin.controller;

import com.amin.model.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.amin.model.Subject;
import com.amin.model.SubjectRepository;
import com.amin.model.Student;
import com.amin.model.StudentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SubjectController {

	private final SubjectRepository subjectRepository;
	//private  StudentRepository student;
	public SubjectController(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}

	@GetMapping("/addsubject")
	public String addSubject(Model model) {
		Subject subject = new Subject();
		model.addAttribute("subject", subject);
		return "addsubject";
	}

	@PostMapping("/addsubject")
	public String addSubject(Subject subject, BindingResult result) {
		
		if (subject.getName().equals("") || subject.getName().matches(".*\\d+.*")) {
			result.rejectValue("name", "name");
			return "addsubject";
		}
		
		this.subjectRepository.save(subject);
		return "redirect:/allstudents";
	}

	@RequestMapping(value = {"/allsubjects", "/"}, method = RequestMethod.GET)
	public String allSubjects(ModelMap model){
	//	model.put("students", student.findAll());
		model.put("subjects", subjectRepository.findAll());
		return "allsubjects";
	}

}

package com.amin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amin.model.Student;
import com.amin.model.StudentRepository;
import com.amin.model.SubjectRepository;

@Controller
@RequestMapping("/students/{studentId}")
public class UpdateController {
	
	private final StudentRepository studentRepository;
	private final SubjectRepository subjectRepository;
		
	
	
	public UpdateController(StudentRepository studentRepository,
			SubjectRepository subjectRepository) {
		this.studentRepository = studentRepository;
		this.subjectRepository = subjectRepository;
	}

	@ModelAttribute("student")
	public Student findStudent(@PathVariable("studentId") int studentId) {
		return this.studentRepository.findOne(studentId);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateGuide(ModelMap model) {
		model.put("subjects", subjectRepository.findAll());

		return "test";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateGuide(Student student, ModelMap model) {
		if(student.getSubCount() >= 4){
			return  "redirect:/allstudents";
		}else {
			this.studentRepository.save(student);
			return "redirect:/allstudents";
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteStudent(Student student, ModelMap model) {
		this.studentRepository.delete(student);
		return "redirect:/allstudents";
	}
	
	
	

}

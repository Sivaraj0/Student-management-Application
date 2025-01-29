package com.example.studentmanagementwithcrud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.studentmanagementwithcrud.model.Student;
import com.example.studentmanagementwithcrud.service.StudentService;
@Controller
@RequestMapping("/students")
public class StudentController {
        
	    @Autowired
	    StudentService str;

	    // Show all students
	    @GetMapping
	    public String getAllStudents(Model m) {
	        m.addAttribute("students", str.getAllStudents());
	        return "students/list";  // Thymeleaf view template
	    }

	    // Show the form to add a new student
	    @GetMapping("/new")
	    public String showStudentForm(Model m) {
	        m.addAttribute("student", new Student());
	        return "students/form";  // Thymeleaf form template
	    }

	    // Save a new or updated student
	    @PostMapping("/save")
	    public String saveStudent(@ModelAttribute Student s) {
	        str.saveStudent(s);
	        return "redirect:/students";  // Redirect to the student list
	    }

	    // Show the form to edit an existing student
	    @GetMapping("/edit/{id}")
	    public String showEditForm(@PathVariable Long id, Model m) {
	        Student student = str.getStudentById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        m.addAttribute("student", student);
	        return "students/form";  // Thymeleaf form template
	    }

	    // Delete a student
	    @GetMapping("/delete/{id}")
	    public String deleteStudent(@PathVariable Long id) {
	        str.deleteStudent(id);
	        return "redirect:/students";  // Redirect to the student list
	    }
	}

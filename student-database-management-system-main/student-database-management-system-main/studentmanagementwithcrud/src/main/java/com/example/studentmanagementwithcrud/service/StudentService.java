package com.example.studentmanagementwithcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagementwithcrud.dao.StudentRepos;
import com.example.studentmanagementwithcrud.model.Student;


@Service
public class StudentService {

	    @Autowired
	 StudentRepos ob;

	    // Save or update a student
	    public Student saveStudent(Student student) {
	        return ob.save(student);
	    }

	    // Get all students
	    public List<Student> getAllStudents() {
	        return ob.findAll();
	    }

	    // Get a student by ID
	    public Optional<Student> getStudentById(Long id) {
	        return ob.findById(id);
	    }

	    // Delete a student by ID
	    public void deleteStudent(Long id) {
	        ob.deleteById(id);
	    }
	}

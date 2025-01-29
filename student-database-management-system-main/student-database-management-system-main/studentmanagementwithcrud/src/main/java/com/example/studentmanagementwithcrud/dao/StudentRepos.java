package com.example.studentmanagementwithcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentmanagementwithcrud.model.Student;



@Repository
public interface StudentRepos extends JpaRepository<Student, Long> {
	
}




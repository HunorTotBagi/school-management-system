package com.electric_diary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.electric_diary.entities.StudentEntity;
import com.electric_diary.services.StudentService;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

	@Autowired
	protected StudentService studentService;

	@PostMapping
	public StudentEntity createStudent(@RequestParam String firstName, @RequestParam String lastName) {
		return studentService.createStudent(firstName, lastName);
	}

	@GetMapping
	public Iterable<StudentEntity> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/{id}")
	public StudentEntity getStudentById(@PathVariable String id) {
		return studentService.getStudentById(id);
	}

	@PutMapping("/{id}")
	public StudentEntity updateStudent(@PathVariable String id, @RequestParam String firstName,
			@RequestParam String lastName) {
		return studentService.updateStudent(id, firstName, lastName);
	}

	@DeleteMapping("/{id}")
	public StudentEntity deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}
}

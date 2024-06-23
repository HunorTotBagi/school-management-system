package com.electric_diary.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electric_diary.entities.TeacherEntity;
import com.electric_diary.services.TeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/teachers")
public class TeacherController {

	@Autowired
	protected TeacherService teacherService;

	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@PostMapping
	public ResponseEntity<TeacherEntity> createTeacher(@Valid @RequestBody TeacherEntity teacherBody, BindingResult result) {
		logger.debug("This is a debug message");
		return new ResponseEntity<>(teacherService.createTeacher(teacherBody, result), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterable<TeacherEntity>> getAllTeachers() {
		logger.info("This is an info message");
		return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TeacherEntity> getTeacherById(@PathVariable String id) {
		logger.warn("This is a warn message");
		return new ResponseEntity<>(teacherService.getTeacherById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TeacherEntity> updateTeacher(@PathVariable String id, @RequestBody TeacherEntity teacherBody) {
		logger.error("This is an error message");
		return new ResponseEntity<>(teacherService.updateTeacher(id, teacherBody), HttpStatus.OK) ;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<TeacherEntity> deleteTeacher(@PathVariable String id) {
		return new ResponseEntity<>(teacherService.deleteTeacher(id), HttpStatus.OK);
	}
	
	@PutMapping("/{teacherId}/subject/{subjectId}")
	public ResponseEntity<TeacherEntity> assignSubjectToTeacher(@PathVariable String teacherId, @PathVariable String subjectId){
		return new ResponseEntity<>(teacherService.assignSubjectToTeacher(teacherId, subjectId), HttpStatus.OK);
	}
}

package com.electric_diary.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electric_diary.entities.StudentEntity;
import com.electric_diary.repositories.StudentRepository;
import com.electric_diary.services.StudentService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class StudentServiceImpl implements StudentService {

	@PersistenceContext
	protected EntityManager em;

	@Autowired
	protected StudentRepository studentRepository;

	@Override
	public StudentEntity createStudent(StudentEntity studentBody) {
		StudentEntity student = new StudentEntity();
		student.setFirstName(studentBody.getFirstName());
		student.setLastName(studentBody.getLastName());
		studentRepository.save(student);
		return student;
	}

	@Override
	public Iterable<StudentEntity> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public StudentEntity getStudentById(String id) {
		return studentRepository.findById(Integer.parseInt(id)).get();
	}

	@Override
	public StudentEntity updateStudent(String id, StudentEntity studentBody) {
		StudentEntity student = studentRepository.findById(Integer.parseInt(id)).get();
		if (student != null) {
			student.setFirstName(studentBody.getFirstName());
			student.setLastName(studentBody.getLastName());
			studentRepository.save(student);
			return student;
		}
		return new StudentEntity();
	}

	@Override
	public StudentEntity deleteStudent(String id) {
		StudentEntity student = studentRepository.findById(Integer.parseInt(id)).get();
		if (student != null) {
			studentRepository.delete(student);
			return student;
		}
		return new StudentEntity();
	}
}
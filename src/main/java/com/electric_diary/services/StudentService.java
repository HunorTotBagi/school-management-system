package com.electric_diary.services;

import com.electric_diary.DTO.StudentDTO;
import com.electric_diary.entities.StudentEntity;

public interface StudentService {
	public StudentEntity createStudent(StudentDTO studentDTOBody);

	public Iterable<StudentEntity> getAllStudents();

	public StudentEntity getStudentById(String id);

	public StudentEntity updateStudent(String id, StudentDTO studentDTOBody);

	public StudentEntity deleteStudent(String id);
}

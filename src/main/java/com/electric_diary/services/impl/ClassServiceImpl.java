package com.electric_diary.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.electric_diary.entities.ClassEntity;
import com.electric_diary.repositories.ClassRepository;
import com.electric_diary.services.ClassService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ClassServiceImpl extends ErrorMessagesServiceImpl implements ClassService {

	@PersistenceContext
	protected EntityManager em;

	@Autowired
	protected ClassRepository classRepository;

	@Override
	public ResponseEntity<?> createClass(ClassEntity classBody, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
		}

		ClassEntity newClass = new ClassEntity();
		newClass.setName(classBody.getName());
		classRepository.save(newClass);

		return new ResponseEntity<>(newClass, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllClasses() {
		Iterable<ClassEntity> newClass = classRepository.findAll();
		return new ResponseEntity<>(newClass, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getClassById(String id) {
		try {
			int classId = Integer.parseInt(id);
			Optional<ClassEntity> classOptional = classRepository.findById(classId);

			if (classOptional.isPresent()) {
				return new ResponseEntity<>(classOptional.get(), HttpStatus.OK);
			} else {
				return createNotFoundResponse("Class", classId);
			}
		} catch (NumberFormatException e) {
			return createBadRequestResponse("Invalid ID format");
		} catch (Exception e) {
			return createErrorResponse(e);
		}
	}

	@Override
	public ResponseEntity<?> updateClass(String id, ClassEntity classBody) {
		try {
			int classId = Integer.parseInt(id);
			Optional<ClassEntity> optionalClass = classRepository.findById(classId);

			if (optionalClass.isPresent()) {
				ClassEntity newClass = optionalClass.get();
				newClass.setName(classBody.getName());
				classRepository.save(newClass);
				return new ResponseEntity<>(newClass, HttpStatus.OK);
			} else {
				return createNotFoundResponse("Class", classId);
			}
		} catch (NumberFormatException e) {
			return createBadRequestResponse("Invalid ID format");
		} catch (Exception e) {
			return createErrorResponse(e);
		}
	}

	@Override
	public ResponseEntity<?> deleteClass(String id) {
		try {
			int classId = Integer.parseInt(id);
			Optional<ClassEntity> optionalClass = classRepository.findById(classId);

			if (optionalClass.isPresent()) {
				ClassEntity newClass = optionalClass.get();
				classRepository.delete(newClass);
				return new ResponseEntity<>(newClass, HttpStatus.OK);
			} else {
				return createNotFoundResponse("Class", classId);
			}
		} catch (NumberFormatException e) {
			return createBadRequestResponse("Invalid ID format");
		} catch (Exception e) {
			return createErrorResponse(e);
		}
	}

}
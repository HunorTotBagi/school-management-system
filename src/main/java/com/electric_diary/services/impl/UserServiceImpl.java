package com.electric_diary.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.electric_diary.entities.UserEntity;
import com.electric_diary.exception.NotFoundException;
import com.electric_diary.repositories.UserRepository;
import com.electric_diary.services.UserService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class UserServiceImpl implements UserService {
	@PersistenceContext
	protected EntityManager entityManager;

	private final UserRepository userRepository;

	public UserServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserEntity createUser(UserEntity userBody) {
		UserEntity user = new UserEntity();
		user.setName(userBody.getName());
		user.setLastName(userBody.getLastName());
		user.setPassword("{noop}" + userBody.getPassword());
		user.setEmail(userBody.getEmail());
		user.setRole(userBody.getRole());
		userRepository.save(user);

		return user;
	}

	@Override
	public Iterable<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUserById(String id) {
		try {
			int userId = Integer.parseInt(id);
			UserEntity user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User", id));
			return user;
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
	}

	@Override
	public UserEntity updateUser(String id, UserEntity userBody) {
		int userId;
		try {
			userId = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}

		Optional<UserEntity> optionalUser = userRepository.findById(userId);
		if (!optionalUser.isPresent())
			throw new NotFoundException("User", id);

		UserEntity user = optionalUser.get();
		user.setName(userBody.getName());
		user.setLastName(userBody.getLastName());
		user.setPassword(userBody.getPassword());
		user.setEmail(userBody.getEmail());
		user.setRole(userBody.getRole());
		userRepository.save(user);
		return user;
	}

	@Override
	public UserEntity deleteUser(String id) {
		int userId;
		try {
			userId = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}

		Optional<UserEntity> optionalUser = userRepository.findById(userId);
		if (!optionalUser.isPresent())
			throw new NotFoundException("User", id);

		UserEntity user = optionalUser.get();
		userRepository.delete(user);
		return user;
	}
}

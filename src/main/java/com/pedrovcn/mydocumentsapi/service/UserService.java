package com.pedrovcn.mydocumentsapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrovcn.mydocumentsapi.exceptions.ExistingUserException;
import com.pedrovcn.mydocumentsapi.model.User;
import com.pedrovcn.mydocumentsapi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		if (repository.findByEmailAndName(user.getEmail(), user.getName()).isPresent()) {
			throw new ExistingUserException("Usuário já cadastrado.");
		}
		
		return repository.save(user);
	}

	public Optional<User> findUserbyId(Long id) {
		return repository.findById(id);
	}
	
	public Optional<User> findByEmailAndPassword(String email, String password) {
		return repository.findByEmailAndPassword(email, password);
	}
	
}

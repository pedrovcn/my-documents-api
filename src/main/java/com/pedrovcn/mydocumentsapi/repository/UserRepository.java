package com.pedrovcn.mydocumentsapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrovcn.mydocumentsapi.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByEmailAndName(String email, String name);
	public Optional<User> findByEmailAndPassword(String email, String password);
	public Optional<User> findByEmail(String email);
	
}

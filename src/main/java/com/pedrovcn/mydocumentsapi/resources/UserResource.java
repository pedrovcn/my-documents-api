package com.pedrovcn.mydocumentsapi.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrovcn.mydocumentsapi.model.User;
import com.pedrovcn.mydocumentsapi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findUser(@PathVariable Long id) {
		Optional<User> user = service.findUserbyId(id);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public User register(@RequestBody User user) {
		User usr = service.saveUser(user);
		return usr;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		Optional<User> usr = service.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return usr.isPresent() ? ResponseEntity.ok(usr) : ResponseEntity.notFound().build();
	}
}

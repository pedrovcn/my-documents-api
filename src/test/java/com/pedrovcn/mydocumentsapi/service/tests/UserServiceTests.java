package com.pedrovcn.mydocumentsapi.service.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.pedrovcn.mydocumentsapi.builders.UserBuilder;
import com.pedrovcn.mydocumentsapi.exceptions.ExistingUserException;
import com.pedrovcn.mydocumentsapi.model.User;
import com.pedrovcn.mydocumentsapi.repository.UserRepository;
import com.pedrovcn.mydocumentsapi.service.UserService;

public class UserServiceTests {

	@InjectMocks
	private UserService service;
	
	@Mock
	private UserRepository repository;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void shouldCreateUser() {
		User user = UserBuilder.aUser().now();
		
		when(repository.save(Mockito.any(User.class))).thenReturn(user);
		
		User savedUser = service.saveUser(user);
		
		assertThat(savedUser.getName(), is(user.getName()));
		assertThat(savedUser.getEmail(), is(user.getEmail()));
		assertThat(savedUser.getPhone(), is(user.getPhone()));
	}
	
	@Test
	public void shouldNotCreateExistingUser() {
		User user = UserBuilder.aUser().now();
		
		service.saveUser(user);
		
		try {
			service.saveUser(user);
		} catch (ExistingUserException e) {
			assertThat(e.getMessage(), is("Usuário já cadastrado."));
		}
		
	}
	
}

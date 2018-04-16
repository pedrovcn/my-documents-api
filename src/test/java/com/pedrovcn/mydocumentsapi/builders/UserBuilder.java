package com.pedrovcn.mydocumentsapi.builders;

import com.pedrovcn.mydocumentsapi.model.User;

public class UserBuilder {

	private User user;
	
	public static UserBuilder aUser() {
		UserBuilder builder = new UserBuilder();
		
		builder.user = new User();
		builder.user.setName("Administratorr");
		builder.user.setEmail("adminrr@company.com");
		builder.user.setPassword("e10adc3949ba59abbe56e057f20f883e");
		
		return builder;
		
	}
	
	public User now() {
		return user;
	}

}

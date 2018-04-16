package com.pedrovcn.mydocumentsapi.builders;

import java.time.LocalDate;

import com.pedrovcn.mydocumentsapi.model.Document;

public class DocumentBuilder {

	private Document document;

	public static DocumentBuilder aDocument() {
		DocumentBuilder builder = new DocumentBuilder();

		builder.document = new Document();
		builder.document.setName("RG");
		builder.document.setDateRegistered(LocalDate.now());
		builder.document.setUser(UserBuilder.aUser().now());
		
		return builder;

	}
	
	public DocumentBuilder withoutName() {
		document.setName(null);
		return this;
	}
	
	public DocumentBuilder withoutUser() {
		document.setUser(null);
		return this;
	}

	public Document now() {
		return document;
	}

}

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

import com.pedrovcn.mydocumentsapi.builders.DocumentBuilder;
import com.pedrovcn.mydocumentsapi.exceptions.MandatoryFieldMissingException;
import com.pedrovcn.mydocumentsapi.model.Document;
import com.pedrovcn.mydocumentsapi.repository.DocumentRepository;
import com.pedrovcn.mydocumentsapi.service.DocumentService;

public class DocumentServiceTests {

	@InjectMocks
	private DocumentService service;
	
	@Mock
	private DocumentRepository repository;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldRegisterDocument() {
		Document doc = DocumentBuilder.aDocument().now();
		
		when(repository.save(Mockito.any(Document.class))).thenReturn(doc);
		
		Document savedDoc = service.saveDocument(doc);
		
		assertThat(savedDoc.getName(), is(doc.getName()));
		assertThat(savedDoc.getUser(), is(doc.getUser()));
	}
	
	@Test
	public void shouldNotRegisterDocumentWithoutName() {
		Document doc = DocumentBuilder.aDocument().withoutName().now();
		
		try {
			service.saveDocument(doc);
		} catch (MandatoryFieldMissingException e) {
			assertThat(e.getMessage(), is("Um nome é requerido."));
		}
	}
	
	@Test
	public void shouldNotRegisterDocumentWithoutUser() {
		Document doc = DocumentBuilder.aDocument().withoutUser().now();
		
		try {
			service.saveDocument(doc);
		} catch (MandatoryFieldMissingException e) {
			assertThat(e.getMessage(), is("Usuário não identificado."));
		}
	}
}

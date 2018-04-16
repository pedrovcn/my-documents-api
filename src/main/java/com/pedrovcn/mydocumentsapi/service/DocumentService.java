package com.pedrovcn.mydocumentsapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pedrovcn.mydocumentsapi.exceptions.MandatoryFieldMissingException;
import com.pedrovcn.mydocumentsapi.filter.DocumentFilter;
import com.pedrovcn.mydocumentsapi.model.Document;
import com.pedrovcn.mydocumentsapi.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository repository;
	
	public Document saveDocument(Document doc) {
		if(doc.getName() == null || doc.getName().isEmpty()) {
			throw new MandatoryFieldMissingException("Um nome é requerido.");
		}
		
		if(doc.getUser() == null) {
			throw new MandatoryFieldMissingException("Usuário não identificado.");
		}
		
		return repository.save(doc);
	}
	
	public List<Document> listAllDocuments() {
		return repository.findAll();
	}

	public Page<Document> filtrar(DocumentFilter documentFilter, Pageable pageable) {
		return repository.filtrar(documentFilter, pageable);
	}
	
}

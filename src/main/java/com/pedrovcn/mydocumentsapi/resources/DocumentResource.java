package com.pedrovcn.mydocumentsapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrovcn.mydocumentsapi.filter.DocumentFilter;
import com.pedrovcn.mydocumentsapi.model.Document;
import com.pedrovcn.mydocumentsapi.service.DocumentService;

@RestController
@RequestMapping("/documents")
public class DocumentResource {
	
	@Autowired
	private DocumentService service;
	
//	@GetMapping
	public List<Document> list() { 
		return service.listAllDocuments();
	}
	
	@PostMapping
	public Document register(@RequestBody Document document) {
		Document doc = service.saveDocument(document);
		return doc;
	}
	
	@GetMapping
	public Page<Document> pesquisar(DocumentFilter documentFilter, Pageable pageable) {
		return service.filtrar(documentFilter, pageable);
	}

}

package com.pedrovcn.mydocumentsapi.repository.document;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import com.pedrovcn.mydocumentsapi.filter.DocumentFilter;
import com.pedrovcn.mydocumentsapi.model.Document;

public interface DocumentRepositoryQuery {
	public Page<Document> filtrar(DocumentFilter documentFilter, Pageable pageable);
}

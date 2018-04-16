package com.pedrovcn.mydocumentsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrovcn.mydocumentsapi.model.Document;
import com.pedrovcn.mydocumentsapi.repository.document.DocumentRepositoryQuery;

public interface DocumentRepository extends JpaRepository<Document, Long>, DocumentRepositoryQuery {

}

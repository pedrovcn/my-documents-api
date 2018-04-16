package com.pedrovcn.mydocumentsapi.repository.document;

import org.springframework.data.domain.Pageable; 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.StringUtils;

import com.pedrovcn.mydocumentsapi.filter.DocumentFilter;
import com.pedrovcn.mydocumentsapi.model.Document;
import com.pedrovcn.mydocumentsapi.model.Document_;

public class DocumentRepositoryImpl implements DocumentRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Document> filtrar(DocumentFilter documentFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Document> criteria = builder.createQuery(Document.class);
		
		Root<Document> root = criteria.from(Document.class);
		
		// criando restrições
		Predicate[] predicates = criarRestricoes(documentFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Document> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(documentFilter));
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
		
	}
	
	private Long total(DocumentFilter documentFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Document> root = criteria.from(Document.class);
		
		Predicate[] predicates = criarRestricoes(documentFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));

		return manager.createQuery(criteria).getSingleResult();
	}
	
	private Predicate[] criarRestricoes(DocumentFilter documentFilter, CriteriaBuilder builder,
			Root<Document> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(documentFilter.getName())) {
			predicates.add(builder.like(
					builder.lower(root.get(Document_.name)), "%" + documentFilter.getName().toLowerCase() + "%"));
		}
		
		if (documentFilter.getStartDate() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(Document_.dateRegistered), documentFilter.getStartDate()));			
		}
		
		if (documentFilter.getEndDate() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get(Document_.dateRegistered), documentFilter.getEndDate()));			
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}


}

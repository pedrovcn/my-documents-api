package com.pedrovcn.mydocumentsapi.model;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Document.class)
public class Document_ {

	public static volatile SingularAttribute<Document, Long> documentId;
	public static volatile SingularAttribute<Document, String> name;
	public static volatile SingularAttribute<Document, LocalDate> dateRegistered;
	public static volatile SingularAttribute<Document, User> user;

}
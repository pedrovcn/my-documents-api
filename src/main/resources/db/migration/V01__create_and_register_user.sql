CREATE TABLE api_user (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	phone CHAR(11) NOT NULL,
	password VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO api_user (name, email, phone, password) VALUES ("AdministradorDBA", "admin@mail.com","99999999999", "e10adc3949ba59abbe56e057f20f883e");
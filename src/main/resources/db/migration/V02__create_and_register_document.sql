CREATE TABLE document (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	date_registered TIMESTAMP,
	user_id BIGINT(20),
	FOREIGN KEY (user_id) REFERENCES api_user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO document (name, user_id) VALUES ("RG", 1);
INSERT INTO document (name, user_id) VALUES ("CNH", 1);
INSERT INTO document (name, user_id) VALUES ("Certidão de nascimento", 1);

INSERT INTO document (name, user_id) VALUES ("RG", 2);
INSERT INTO document (name, user_id) VALUES ("CNH", 2);
INSERT INTO document (name, user_id) VALUES ("Certidão de nascimento", 2);
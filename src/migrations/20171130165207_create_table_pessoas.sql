CREATE TABLE pessoas(
	id int(11) DEFAULT NULL auto_increment PRIMARY KEY,
	name VARCHAR(140),
	last_name VARCHAR(200),
	created_at DATETIME,
	updated_at DATETIME
)ENGINE=InnoDB;;

INSERT INTO tag (value)
	VALUES 
	('sci-fi'),
	('policier'),
	('aventure'),
	('histoire');
	
INSERT INTO author (first_name, last_name) 
	VALUES 
	('Victor', 'Hugo'),
	('René', 'Barjavel'),
	('Dan', 'Brown');
	
INSERT INTO publisher (name) 
	VALUES 
	('Gallimard'),
	('Hachette'),
	('France Loisir');
	
INSERT INTO book (name, author_id, copy, publisher_id) 
	VALUES 
	('Les misérables', 1, 3, 1),
	('La nuit des temps', 2, 2, 2),
	('Da vinci code', 3, 2, 3);
	
INSERT INTO book_tag (book_id, tag_id) 
	VALUES 
	(1, 3),
	(2, 1),
	(3, 2),
	(3, 3);

INSERT INTO account (first_name, last_name, email, password) 
	VALUES
	('bruno', 'zilio', 'bruno.zilio@g.com', 'bruno'),
	('yoann', 'dubois', 'yoann.dubois@g.com', 'yoann');
	
INSERT INTO rental (account_id, book_id, dead_line) 
	VALUES 
	(1, 2, CURRENT_DATE + INTERVAL '1 months'),
	(2, 1, CURRENT_DATE + INTERVAL '1 week');


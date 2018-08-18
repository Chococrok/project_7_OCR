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
	('Da vinci code', 3, 2, 3),
	('Tintin', 1, 1, 1);
	
INSERT INTO book_tag (book_id, tag_id) 
	VALUES 
	(1, 3),
	(2, 1),
	(3, 2),
	(3, 3);

INSERT INTO account (first_name, last_name, email, password) 
	VALUES
	('bruno', 'zilio', 'bruno@g.com', 'bruno'),
	('yoann', 'dubois', 'yoann@g.com', 'yoann'),
	('arnaud', 'barbaria', 'arnaud@g.com', 'arnaud'),
	('laure', 'ferras', 'laure@g.com', 'laure');
	
INSERT INTO rental (account_id, book_id, dead_line) 
	VALUES 
	(1, 2, CURRENT_DATE + INTERVAL '1 months'),
	(1, 1, CURRENT_DATE + INTERVAL '1 months'),
	(1, 4, CURRENT_DATE + INTERVAL '1 month'),
	(2, 1, CURRENT_DATE + INTERVAL '1 week'),
	(2, 2, CURRENT_DATE + INTERVAL '1 week'),
	(2, 3, CURRENT_DATE + INTERVAL '1 week'),
	(3, 3, CURRENT_DATE - INTERVAL '1 week');

INSERT INTO reservation (account_id, book_id, reservation_end)
	VALUES 
	(2, 4, CURRENT_TIMESTAMP + INTERVAL '2 minute' + INTERVAL '2 hour'),
	(3, 4, NULL);


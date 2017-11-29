DROP TABLE IF EXISTS account, tag, book, publisher, author, rental, book_tag CASCADE;

CREATE SEQUENCE public.publisher_id_seq;

CREATE TABLE public.publisher (
                id INTEGER NOT NULL DEFAULT nextval('public.publisher_id_seq'),
                name VARCHAR NOT NULL,
                CONSTRAINT publisher_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.publisher_id_seq OWNED BY public.publisher.id;

CREATE SEQUENCE public.author_id_seq;

CREATE TABLE public.author (
                id INTEGER NOT NULL DEFAULT nextval('public.author_id_seq'),
                first_name VARCHAR,
                last_name VARCHAR NOT NULL,
                CONSTRAINT author_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.author_id_seq OWNED BY public.author.id;

CREATE SEQUENCE public.account_id_seq;

CREATE TABLE public.account (
                id INTEGER NOT NULL DEFAULT nextval('public.account_id_seq'),
                first_name VARCHAR NOT NULL,
                last_name VARCHAR NOT NULL,
                email VARCHAR NOT NULL,
                phone_number VARCHAR,
                CONSTRAINT account_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.account_id_seq OWNED BY public.account.id;

CREATE SEQUENCE public.tag_id_seq;

CREATE TABLE public.tag (
                id INTEGER NOT NULL DEFAULT nextval('public.tag_id_seq'),
                value VARCHAR NOT NULL,
                CONSTRAINT tag_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.tag_id_seq OWNED BY public.tag.id;

CREATE SEQUENCE public.book_id_seq;

CREATE TABLE public.book (
                id INTEGER NOT NULL DEFAULT nextval('public.book_id_seq'),
                name VARCHAR NOT NULL,
                copy INTEGER NOT NULL,
                author_id INTEGER NOT NULL,
                publisher_id INTEGER NOT NULL,
                CONSTRAINT book_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.book_id_seq OWNED BY public.book.id;

CREATE TABLE public.book_tag (
                book_id INTEGER NOT NULL,
                tag_id INTEGER NOT NULL,
                CONSTRAINT book_tag_pk PRIMARY KEY (book_id, tag_id)
);


CREATE TABLE public.rental (
                account_id INTEGER NOT NULL,
                book_id INTEGER NOT NULL,
                is_extended BOOLEAN DEFAULT false,
                dead_line DATE NOT NULL,
                CONSTRAINT rental_pk PRIMARY KEY (account_id, book_id)
);


ALTER TABLE public.book ADD CONSTRAINT publisher_book_fk
FOREIGN KEY (publisher_id)
REFERENCES public.publisher (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.book ADD CONSTRAINT author_book_fk
FOREIGN KEY (author_id)
REFERENCES public.author (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.rental ADD CONSTRAINT user_rental_fk
FOREIGN KEY (account_id)
REFERENCES public.account (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.book_tag ADD CONSTRAINT tag_book_tag_fk
FOREIGN KEY (tag_id)
REFERENCES public.tag (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.rental ADD CONSTRAINT book_rental_fk
FOREIGN KEY (book_id)
REFERENCES public.book (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.book_tag ADD CONSTRAINT book_book_tag_fk
FOREIGN KEY (book_id)
REFERENCES public.book (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

CREATE SEQUENCE public.reservation_traker;


CREATE TABLE public.reservation (
                account_id INTEGER NOT NULL,
                book_id INTEGER NOT NULL,
                reservation_end TIMESTAMP,
                reservation_number INTEGER NOT NULL DEFAULT nextval('public.reservation_traker'),
                CONSTRAINT reservation_pk PRIMARY KEY (account_id, book_id)
);

ALTER SEQUENCE public.reservation_traker OWNED BY public.reservation.reservation_number;

ALTER TABLE public.reservation ADD CONSTRAINT book_reservation_fk
FOREIGN KEY (book_id)
REFERENCES public.book (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation ADD CONSTRAINT user_reservation_fk
FOREIGN KEY (account_id)
REFERENCES public.account (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

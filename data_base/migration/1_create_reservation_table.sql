CREATE TABLE public.reservation (
                account_id INTEGER NOT NULL,
                book_id INTEGER NOT NULL,
                reservation_end DATE,
                CONSTRAINT reservation_pk PRIMARY KEY (account_id, book_id)
);

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

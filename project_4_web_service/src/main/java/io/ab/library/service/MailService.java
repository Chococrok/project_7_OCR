package io.ab.library.service;

import io.ab.library.model.Account;
import io.ab.library.model.Book;

public interface MailService {
	public static final String FROM = "reminderservice@ab.io";

	void sendBookAvailable(Account account, Book book);

}

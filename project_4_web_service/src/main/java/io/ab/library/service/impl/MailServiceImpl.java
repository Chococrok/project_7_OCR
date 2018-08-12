package io.ab.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import io.ab.library.model.Account;
import io.ab.library.model.Book;
import io.ab.library.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	private static final String RESERVATION_TOP = "Bonjour %s %s,\n "
			+ "vous recevez ce mail car vous êtes êtes dorénavant en tête de file\n"
			+ "pour le livre %s de %s %s. Vous avez 48h pour venir le chercher.\n" + "votre libaire préféré.";

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Override
	public void sendBookAvailable(Account account, Book book) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(MailService.FROM);
		simpleMailMessage.setSubject(book.getName() + " est de retour sur no étagères!");
		simpleMailMessage.setTo(account.getEmail());

		simpleMailMessage.setText(String.format(
				RESERVATION_TOP,
				account.getFirstName(),
				account.getLastName(),
				book.getName(),
				book.getAuthor().getFirstName(),
				book.getAuthor().getLastName())
				);

		try {
			this.mailSender.send(simpleMailMessage);
		} catch (MailException ex) {
			System.err.println("### an error occured while sending email !! ###");
			System.err.println(ex.getMessage());
		}
	}
}

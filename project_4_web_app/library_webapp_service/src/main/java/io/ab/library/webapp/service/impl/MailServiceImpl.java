package io.ab.library.webapp.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import io.ab.library.webapp.service.MailService;
import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.Book;

@Service
public class MailServiceImpl implements MailService {

	private static final String MSG_BEGGINING = "Bonjour %firstName %lastName,\n "
			+ "vous recevez ce mail car les livres \n";
	private static final String MSG_END = "que vous avez emprunté, doivent être ramené dans moins de 5 jours !. \n "
			+ "Cordialement, \n " + "votre bibliothèque préféré.";

	@Autowired
	private JavaMailSenderImpl mailSender;

	public void sendBookAvailable(Account account, Book book) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(FROM);
		simpleMailMessage.setSubject(book.getName() + " est de retour sur no étagères!");

		try {
			this.mailSender.send(simpleMailMessage);
		} catch (MailException ex) {
			System.err.println("### an error occured while sending email !! ###");
			System.err.println(ex.getMessage());
		}
	}
}

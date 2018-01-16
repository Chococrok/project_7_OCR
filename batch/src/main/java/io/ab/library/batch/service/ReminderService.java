package io.ab.library.batch.service;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import io.ab.library.batch.client.RentalClient;

@Service
public class ReminderService {

	private static final Logger log = LoggerFactory.getLogger(ReminderService.class);
	private static final String MSG = "Bonjour %firstName %lastName,\n "
			+ "vous recevez ce mail car vous n'avez pas rendu le livre %bookName de %autor.\n "
			+ "vous auriez du rendre ce livre le %date.\n " + "Merci de ramener ce livre au plus vite. \n "
			+ "Cordialement, \n " + "votre bibliothèque préféré.";

	@Autowired
	private RentalClient rentalClient;
	@Autowired
	private SimpleMailMessage mailMsg;
	@Autowired
	private JavaMailSenderImpl mailSender;

	public void sendReminder() {
		this.rentalClient.getAllRentals().forEach(rental -> {
			if (rental.getDeadLine().toGregorianCalendar().before(Calendar.getInstance())) {
				log.debug("sending email to:" + rental.getAccount().getEmail());
				mailMsg.setTo(rental.getAccount().getEmail());
				mailMsg.setText(this.buildMsgContent(rental.getAccount().getFirstName(),
						rental.getAccount().getLastName(), rental.getDeadLine().toString(), rental.getBook().getName(),
						rental.getBook().getAuthor().getFirstName() + " "
								+ rental.getBook().getAuthor().getLastName()));
				try {
					this.mailSender.send(mailMsg);
				} catch (MailException ex) {
					System.err.println(ex.getMessage());
				}
			}
		});
	}

	private String buildMsgContent(String firstName, String lastName, String date, String bookName, String autor) {
		String msg = MSG.replace("%firstName", firstName);
		msg = msg.replace("%lastName", lastName);
		msg = msg.replace("%date", date);
		msg = msg.replace("%bookName", bookName);
		msg = msg.replace("%autor", autor);

		return msg;
	}
}
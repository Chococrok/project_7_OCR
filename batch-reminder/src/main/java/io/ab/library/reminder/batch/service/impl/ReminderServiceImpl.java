package io.ab.library.reminder.batch.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import io.ab.library.reminder.batch.client.impl.RentalClientImpl;
import io.ab.library.reminder.batch.service.ReminderService;

@Service
public class ReminderServiceImpl implements ReminderService {

	private static final Logger log = LoggerFactory.getLogger(ReminderServiceImpl.class);
	private static final String MSG_BEGGINING = "Bonjour %firstName %lastName,\n "
			+ "vous recevez ce mail car les livres \n";
	private static final String MSG_END = "que vous avez emprunté, doivent être ramené dans moins de 5 jours !. \n "
			+ "Cordialement, \n " + "votre bibliothèque préféré.";

	@Autowired
	private RentalClientImpl rentalClient;
	@Autowired
	private SimpleMailMessage mailMsg;
	@Autowired
	private JavaMailSenderImpl mailSender;

	public void sendReminder() {
		Map<String, SimpleMailMessage> mailsToSend = new HashMap<>();
		
		Calendar adjustedDate = Calendar.getInstance();
		adjustedDate.add(Calendar.DAY_OF_MONTH, 5);
		
		
		this.rentalClient.getAllRentals().forEach(rental -> {
			if (rental.getDeadLine().toGregorianCalendar().before(adjustedDate)
					&& rental.getAccount().isReminder()) {

				SimpleMailMessage msg = mailsToSend.get(rental.getAccount().getEmail());
				if (msg == null) {
					msg = new SimpleMailMessage(mailMsg);
					
					msg.setTo(rental.getAccount().getEmail());
					
					String begginingMsg = MSG_BEGGINING.replaceAll("%firstName", rental.getAccount().getFirstName());
					begginingMsg = begginingMsg.replaceAll("%lastName", rental.getAccount().getLastName());
					
					msg.setText(begginingMsg);
					msg.setText(
							msg.getText() 
							+ "- " 
							+ rental.getBook().getName()
							+ " de "
							+ rental.getBook().getAuthor().getFirstName()
							+ " "
							+ rental.getBook().getAuthor().getLastName()
							+ " ( retour: " +  format(rental.getDeadLine().toGregorianCalendar()) + " )"
							+ " \n");
					
					mailsToSend.put(rental.getAccount().getEmail(), msg);
				} else {
					msg.setText(
							msg.getText() 
							+ "- " 
							+ rental.getBook().getName()
							+ " de "
							+ rental.getBook().getAuthor().getFirstName()
							+ " "
							+ rental.getBook().getAuthor().getLastName()
							+ " ( " +  format(rental.getDeadLine().toGregorianCalendar()) + " )"
							+ " \n");
					
					mailsToSend.put(rental.getAccount().getEmail(), msg);
				}
			}
		});
		
		try {
			mailsToSend.values().stream().forEach(mail -> {
				mail.setText(mail.getText() + MSG_END);
				
				this.mailSender.send(mail);
				System.out.println("### email sent to: " + mail.getTo()[0] + " ###");
			});
		} catch (MailException ex) {
			System.err.println("### an error occured while sending email !! ###");
			System.err.println(ex.getMessage());
		}
	}
	
	private String format(Calendar cal) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		
		return sdf.format(cal.getTime());
	}
	
}

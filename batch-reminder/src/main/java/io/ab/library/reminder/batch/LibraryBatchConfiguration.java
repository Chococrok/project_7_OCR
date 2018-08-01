
package io.ab.library.reminder.batch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class LibraryBatchConfiguration {

	private static final String SUBJECT = "Retard de remise de livre";
	private static final String FROM = "reminderservice@ab.io";

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("io.ab.library.reminder.batch.wsdl");
		return marshaller;
	}
	
//	@Bean
//	public JavaMailSenderImpl javaMailSender() {
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		mailSender.setHost("mail.ab.io");
//		mailSender.getJavaMailProperties().setProperty("mail.smtp.connectiontimeout", "5000");
//		mailSender.getJavaMailProperties().setProperty("mail.smtp.timeout", "5000");
//		mailSender.getJavaMailProperties().setProperty("mail.smtp.writetimeout", "5000");
//		return mailSender;
//	}
	
	@Bean
	public SimpleMailMessage simpleMailMessage() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(FROM);
		simpleMailMessage.setSubject(SUBJECT);
		return simpleMailMessage;
	}

}

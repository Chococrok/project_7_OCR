
package io.ab.library.batch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.ab.library.batch.service.impl.ReminderServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(ReminderServiceImpl reminderService) {
		return args -> {
			reminderService.sendReminder();
		};
	}

}

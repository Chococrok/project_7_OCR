
package io.ab.library.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import io.ab.library.webapp.client.AuthorClient;

@Configuration
public class LibraryConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("io.ab.library.webapp.wsdl");
		return marshaller;
	}

	@Bean
	public AuthorClient authorClient(Jaxb2Marshaller marshaller) {
		AuthorClient client = new AuthorClient();
		client.setDefaultUri("http://localhost:8080/soap");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}

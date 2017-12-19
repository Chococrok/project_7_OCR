
package io.ab.library.webapp.client;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import io.ab.library.webapp.wsdl.GetAllAuthorsResponse;
import io.ab.library.webapp.wsdl.ObjectFactory;

@Component
public class AuthorClient extends WebServiceGatewaySupport {

	
	private ObjectFactory objectFactory;

	public GetAllAuthorsResponse getAuthors() {
		
		objectFactory = new ObjectFactory();

		GetAllAuthorsResponse response = (GetAllAuthorsResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/soap",
						objectFactory.createGetAllAuthorsRequest(null),
						null);

		return response;
	}

}

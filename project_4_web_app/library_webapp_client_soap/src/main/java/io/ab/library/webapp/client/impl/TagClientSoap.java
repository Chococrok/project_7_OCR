
package io.ab.library.webapp.client.impl;

import java.util.List;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import io.ab.library.webapp.client.TagClient;
import io.ab.library.webapp.wsdl.GetAllTagsResponse;
import io.ab.library.webapp.wsdl.ObjectFactory;
import io.ab.library.webapp.wsdl.Tag;

@Component
public class TagClientSoap extends AbstractClientSoap implements TagClient {

	public TagClientSoap(ObjectFactory objectFactory, Jaxb2Marshaller marshaller) {
		super(objectFactory, marshaller);
		// TODO Auto-generated constructor stub
	}

	public List<Tag> getAllTags() {
		
		this.objectFactory = new ObjectFactory();

		GetAllTagsResponse response = (GetAllTagsResponse) getWebServiceTemplate()
				.marshalSendAndReceive(objectFactory.createGetAllTagsRequest(null));
		return response.getTags();
	}

}

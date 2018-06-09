package io.ab.library.util.exception;

import org.springframework.ws.soap.SoapFaultException;
import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode=FaultCode.CLIENT, locale="fr")
public class AlreadyExistsException extends SoapFaultException{

	public AlreadyExistsException(String entityType) {
		super(String.format("this %s already exists", entityType));
	}
}

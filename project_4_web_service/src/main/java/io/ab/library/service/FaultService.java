package io.ab.library.service;

import javax.xml.soap.SOAPException;
import javax.xml.ws.soap.SOAPFaultException;

public interface FaultService {
	
	void sendNewClientSoapFault(String msg) throws SOAPException, SOAPFaultException;

}

package io.ab.library.util;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

public abstract class FaultThrower {

	public static void sendNewClientSoapFault(String msg) throws SOAPException, SOAPFaultException {
		SOAPFactory soapFactory = SOAPFactory.newInstance();
		SOAPFault soapFault = soapFactory.createFault(msg,
				new QName("http://schemas.xmlsoap.org/soap/envelope/", "Client"));
		throw new SOAPFaultException(soapFault);
	}

}

//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.12.18 à 11:04:22 PM CET 
//


package io.ab.library.webapp.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.springframework.stereotype.Component;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.ab.library.webapp.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@Component
@XmlRegistry
public class ObjectFactory {

    private final static QName _String_QNAME = new QName("http://ab.io/library", "string");
    private final static QName _GetAllAuthorsRequest_QNAME = new QName("http://ab.io/library", "getAllAuthorsRequest");
    private final static QName _GetAllBooksRequest_QNAME = new QName("http://ab.io/library", "getAllBooksRequest");
    private final static QName _SignInRequest_QNAME = new QName("http://ab.io/library", "signInRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.ab.library.webapp.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllAuthorsResponse }
     * 
     */
    public GetAllAuthorsResponse createGetAllAuthorsResponse() {
        return new GetAllAuthorsResponse();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link GetAllBooksResponse }
     * 
     */
    public GetAllBooksResponse createGetAllBooksResponse() {
        return new GetAllBooksResponse();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link Rental }
     * 
     */
    public Rental createRental() {
        return new Rental();
    }

    /**
     * Create an instance of {@link Publisher }
     * 
     */
    public Publisher createPublisher() {
        return new Publisher();
    }

    /**
     * Create an instance of {@link Tag }
     * 
     */
    public Tag createTag() {
        return new Tag();
    }

    /**
     * Create an instance of {@link RentalPK }
     * 
     */
    public RentalPK createRentalPK() {
        return new RentalPK();
    }

    /**
     * Create an instance of {@link SignInForm }
     * 
     */
    public SignInForm createSignInForm() {
        return new SignInForm();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ab.io/library", name = "getAllAuthorsRequest")
    public JAXBElement<Object> createGetAllAuthorsRequest(Object value) {
        return new JAXBElement<Object>(_GetAllAuthorsRequest_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ab.io/library", name = "getAllBooksRequest")
    public JAXBElement<Object> createGetAllBooksRequest(Object value) {
        return new JAXBElement<Object>(_GetAllBooksRequest_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ab.io/library", name = "signInRequest")
    public JAXBElement<Object> createSignInRequest(Object value) {
        return new JAXBElement<Object>(_SignInRequest_QNAME, Object.class, null, value);
    }

}

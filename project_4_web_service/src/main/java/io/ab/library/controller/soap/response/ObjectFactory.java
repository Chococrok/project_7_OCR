//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.07.22 à 10:48:36 PM CEST 
//


package io.ab.library.controller.soap.response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.springframework.stereotype.Component;

import io.ab.library.model.*;
import io.ab.library.controller.soap.dto.*;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.ab.library.controller.soap.response package. 
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

    private final static QName _DeleteReservationResponse_QNAME = new QName("http://ab.io/library", "deleteReservationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.ab.library.controller.soap.response
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllRentalsResponse }
     * 
     */
    public GetAllRentalsResponse createGetAllRentalsResponse() {
        return new GetAllRentalsResponse();
    }

    /**
     * Create an instance of {@link Rental }
     * 
     */
    public Rental createRental() {
        return new Rental();
    }

    /**
     * Create an instance of {@link GetRentalsByUserResponse }
     * 
     */
    public GetRentalsByUserResponse createGetRentalsByUserResponse() {
        return new GetRentalsByUserResponse();
    }

    /**
     * Create an instance of {@link GetRentalByIdResponse }
     * 
     */
    public GetRentalByIdResponse createGetRentalByIdResponse() {
        return new GetRentalByIdResponse();
    }

    /**
     * Create an instance of {@link UpdateRentalResponse }
     * 
     */
    public UpdateRentalResponse createUpdateRentalResponse() {
        return new UpdateRentalResponse();
    }

    /**
     * Create an instance of {@link GetAllReservationByBookResponse }
     * 
     */
    public GetAllReservationByBookResponse createGetAllReservationByBookResponse() {
        return new GetAllReservationByBookResponse();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link GetAllReservationByAccountResponse }
     * 
     */
    public GetAllReservationByAccountResponse createGetAllReservationByAccountResponse() {
        return new GetAllReservationByAccountResponse();
    }

    /**
     * Create an instance of {@link GetLastReservationResponse }
     * 
     */
    public GetLastReservationResponse createGetLastReservationResponse() {
        return new GetLastReservationResponse();
    }

    /**
     * Create an instance of {@link AddReservationResponse }
     * 
     */
    public AddReservationResponse createAddReservationResponse() {
        return new AddReservationResponse();
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
     * Create an instance of {@link SearchBooksResponse }
     * 
     */
    public SearchBooksResponse createSearchBooksResponse() {
        return new SearchBooksResponse();
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
     * Create an instance of {@link GetAllTagsResponse }
     * 
     */
    public GetAllTagsResponse createGetAllTagsResponse() {
        return new GetAllTagsResponse();
    }

    /**
     * Create an instance of {@link Tag }
     * 
     */
    public Tag createTag() {
        return new Tag();
    }

    /**
     * Create an instance of {@link SignInResponse }
     * 
     */
    public SignInResponse createSignInResponse() {
        return new SignInResponse();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link Publisher }
     * 
     */
    public Publisher createPublisher() {
        return new Publisher();
    }

    /**
     * Create an instance of {@link RentalPK }
     * 
     */
    public RentalPK createRentalPK() {
        return new RentalPK();
    }

    /**
     * Create an instance of {@link ReservationPK }
     * 
     */
    public ReservationPK createReservationPK() {
        return new ReservationPK();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://ab.io/library", name = "deleteReservationResponse")
    public JAXBElement<Object> createDeleteReservationResponse(Object value) {
        return new JAXBElement<Object>(_DeleteReservationResponse_QNAME, Object.class, null, value);
    }

}

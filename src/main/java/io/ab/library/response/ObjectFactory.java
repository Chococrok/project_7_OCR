//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.12.01 à 09:05:28 PM CET 
//


package io.ab.library.response;

import javax.xml.bind.annotation.XmlRegistry;

import io.ab.library.model.Account;
import io.ab.library.model.Author;
import io.ab.library.model.Rental;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.ab.library.response package. 
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
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.ab.library.response
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
}

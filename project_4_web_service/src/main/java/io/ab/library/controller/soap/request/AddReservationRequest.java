//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.06.08 à 07:19:49 PM CEST 
//


package io.ab.library.controller.soap.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="bookId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accountId",
    "bookId"
})
@XmlRootElement(name = "addReservationRequest")
public class AddReservationRequest {

    protected int accountId;
    protected int bookId;

    /**
     * Obtient la valeur de la propriété accountId.
     * 
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Définit la valeur de la propriété accountId.
     * 
     */
    public void setAccountId(int value) {
        this.accountId = value;
    }

    /**
     * Obtient la valeur de la propriété bookId.
     * 
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Définit la valeur de la propriété bookId.
     * 
     */
    public void setBookId(int value) {
        this.bookId = value;
    }

}

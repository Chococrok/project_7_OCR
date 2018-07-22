//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.07.20 à 11:38:25 PM CEST 
//


package io.ab.library.webapp.wsdl;

import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * The persistent class for the rental database table.
 * 
 * <p>Classe Java pour reservation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reservation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="account" type="{http://ab.io/library}account" minOccurs="0"/&gt;
 *         &lt;element name="book" type="{http://ab.io/library}book" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://ab.io/library}reservationPK" minOccurs="0"/&gt;
 *         &lt;element name="reservationEnd" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservation", propOrder = {
    "account",
    "book",
    "id",
    "reservationEnd"
})
public class Reservation {

    protected Account account;
    protected Book book;
    protected ReservationPK id;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar reservationEnd;

    /**
     * Obtient la valeur de la propriété account.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Définit la valeur de la propriété account.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setAccount(Account value) {
        this.account = value;
    }

    /**
     * Obtient la valeur de la propriété book.
     * 
     * @return
     *     possible object is
     *     {@link Book }
     *     
     */
    public Book getBook() {
        return book;
    }

    /**
     * Définit la valeur de la propriété book.
     * 
     * @param value
     *     allowed object is
     *     {@link Book }
     *     
     */
    public void setBook(Book value) {
        this.book = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link ReservationPK }
     *     
     */
    public ReservationPK getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link ReservationPK }
     *     
     */
    public void setId(ReservationPK value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété reservationEnd.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReservationEnd() {
        return reservationEnd;
    }

    /**
     * Définit la valeur de la propriété reservationEnd.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReservationEnd(XMLGregorianCalendar value) {
        this.reservationEnd = value;
    }
    
    // Not generated methods
    public String getReservationEndFormated() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    	return dateFormat.format(this.reservationEnd.toGregorianCalendar().getTime());
    }

}

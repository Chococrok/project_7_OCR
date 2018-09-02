//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.09.02 à 03:07:18 AM CEST 
//

package io.ab.library.webapp.service.pojo;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.Book;
import io.ab.library.webapp.wsdl.Rental;
import io.ab.library.webapp.wsdl.Reservation;
import io.ab.library.webapp.wsdl.ReservationPK;

/**
 * The persistent class for the rental database table.
 * 
 * <p>
 * Classe Java pour reservation complex type.
 * 
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
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
 *         &lt;element name="reservationNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class ReservationPOJO extends Reservation {
	
	Rental soonestReturned;
	
	public ReservationPOJO(Reservation reservation) {
		this.account = reservation.getAccount();
		this.book = reservation.getBook();
		
		for(Rental rental : this.book.getRentals()) {
			if (this.soonestReturned == null) {
				this.soonestReturned = rental;
			}
			
			if (rental.getDeadLine().toGregorianCalendar().before(soonestReturned.getDeadLine().toGregorianCalendar())) {
				this.soonestReturned = rental;
			}
		}
		this.id = reservation.getId();
		this.reservationEnd = reservation.getReservationEnd();
		this.reservationNumber = reservation.getReservationNumber();
	}
	

	/**
	 * Obtient la valeur de la propriété account.
	 * 
	 * @return possible object is {@link Account }
	 * 
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Définit la valeur de la propriété account.
	 * 
	 * @param value
	 *            allowed object is {@link Account }
	 * 
	 */
	public void setAccount(Account value) {
		this.account = value;
	}

	/**
	 * Obtient la valeur de la propriété book.
	 * 
	 * @return possible object is {@link Book }
	 * 
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * Définit la valeur de la propriété book.
	 * 
	 * @param value
	 *            allowed object is {@link Book }
	 * 
	 */
	public void setBook(Book value) {
		this.book = value;
	}

	/**
	 * Obtient la valeur de la propriété id.
	 * 
	 * @return possible object is {@link ReservationPK }
	 * 
	 */
	public ReservationPK getId() {
		return id;
	}

	/**
	 * Définit la valeur de la propriété id.
	 * 
	 * @param value
	 *            allowed object is {@link ReservationPK }
	 * 
	 */
	public void setId(ReservationPK value) {
		this.id = value;
	}

	/**
	 * Obtient la valeur de la propriété reservationEnd.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getReservationEnd() {
		return reservationEnd;
	}

	/**
	 * Définit la valeur de la propriété reservationEnd.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setReservationEnd(XMLGregorianCalendar value) {
		this.reservationEnd = value;
	}

	/**
	 * Obtient la valeur de la propriété reservationNumber.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public int getReservationNumber() {
		return reservationNumber;
	}

	/**
	 * Définit la valeur de la propriété reservationNumber.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setReservationNumber(int value) {
		this.reservationNumber = value;
	}
	
	

	public Rental getSoonestReturned() {
		return soonestReturned;
	}


	public void setSoonestReturned(Rental soonestReturned) {
		this.soonestReturned = soonestReturned;
	}


	// Not generated methods
	public String getReservationEndFormated() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
		return dateFormat.format(this.reservationEnd.toGregorianCalendar().getTime());
	}

}

//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.12.24 à 12:14:58 AM CET 
//


package io.ab.library.webapp.wsdl;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.google.gson.Gson;


/**
 * The persistent class for the rental database table.
 * 
 * <p>Classe Java pour rental complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="rental"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="account" type="{http://ab.io/library}account" minOccurs="0"/&gt;
 *         &lt;element name="book" type="{http://ab.io/library}book" minOccurs="0"/&gt;
 *         &lt;element name="deadLine" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="extended" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://ab.io/library}rentalPK" minOccurs="0"/&gt;
 *         &lt;element name="rentalOver" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rental", propOrder = {
    "account",
    "book",
    "deadLine",
    "id",
    "extended",
    "rentalOver"
})
public class Rental {

    protected Account account;
    protected Book book;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deadLine;
    protected RentalPK id;
    protected Boolean extended;
    protected Boolean rentalOver;

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
     * Obtient la valeur de la propriété deadLine.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeadLine() {
        return deadLine;
    }

    /**
     * Définit la valeur de la propriété deadLine.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeadLine(String value) {
    	DatatypeFactory factory = null;
		try {
			factory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.deadLine = factory.newXMLGregorianCalendar(value);
    }
    
    public void setDeadLine(XMLGregorianCalendar value) {
        this.deadLine = value;
    }
    
    public void setDeadLine(GregorianCalendar value) {
    	DatatypeFactory factory = null;
		try {
			factory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.deadLine = factory.newXMLGregorianCalendar(value);
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link RentalPK }
     *     
     */
    public RentalPK getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link RentalPK }
     *     
     */
    public void setId(RentalPK value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété isExtended.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */

	public Boolean getExtended() {
		return extended;
	}

	public Boolean isExtended() {
		return this.extended;
	}

	public void setExtended(Boolean extended) {
		this.extended = extended;
	}
	
	public Boolean getRentalOver() {
        return rentalOver;
    }

    public Boolean isRentalOver() {
        return rentalOver;
    }

    public void setRentalOver(Boolean value) {
        this.rentalOver = value;
    }
    
    public String toJson() {
    	Gson gson = new Gson();
    	return gson.toJson(this);
    }
    
 // Not generated methods
 	public String getDeadLineFormated() {
 		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
 		return dateFormat.format(this.deadLine.toGregorianCalendar().getTime());
 	}

}

//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.01.05 à 03:45:40 PM CET 
//


package io.ab.library.controller.soap.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import io.ab.library.model.Rental;


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
 *         &lt;element name="rentals" type="{http://ab.io/library}rental"/&gt;
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
    "rental"
})
@XmlRootElement(name = "getRentalByIdResponse")
public class GetRentalByIdResponse {

    @XmlElement(required = true)
    protected Rental rental;

    /**
     * Obtient la valeur de la propriété rentals.
     * 
     * @return
     *     possible object is
     *     {@link Rental }
     *     
     */
    public Rental getRental() {
        return rental;
    }

    /**
     * Définit la valeur de la propriété rentals.
     * 
     * @param value
     *     allowed object is
     *     {@link Rental }
     *     
     */
    public void setRental(Rental value) {
        this.rental = value;
    }

}

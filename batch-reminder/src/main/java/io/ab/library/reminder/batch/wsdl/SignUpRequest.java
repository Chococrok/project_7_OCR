//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.07.30 à 10:08:22 PM CEST 
//


package io.ab.library.reminder.batch.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="signUpForm" type="{http://ab.io/library}SignUpForm"/&gt;
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
    "signUpForm"
})
@XmlRootElement(name = "signUpRequest")
public class SignUpRequest {

    @XmlElement(required = true)
    protected SignUpForm signUpForm;

    /**
     * Obtient la valeur de la propriété signUpForm.
     * 
     * @return
     *     possible object is
     *     {@link SignUpForm }
     *     
     */
    public SignUpForm getSignUpForm() {
        return signUpForm;
    }

    /**
     * Définit la valeur de la propriété signUpForm.
     * 
     * @param value
     *     allowed object is
     *     {@link SignUpForm }
     *     
     */
    public void setSignUpForm(SignUpForm value) {
        this.signUpForm = value;
    }

}

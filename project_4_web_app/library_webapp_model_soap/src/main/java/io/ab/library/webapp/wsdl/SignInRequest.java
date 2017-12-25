//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.12.24 à 12:14:58 AM CET 
//


package io.ab.library.webapp.wsdl;

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
 *         &lt;element name="signInForm" type="{http://ab.io/library}SignInForm"/&gt;
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
    "signInForm"
})
@XmlRootElement(name = "signInRequest")
public class SignInRequest {

    @XmlElement(required = true)
    protected SignInForm signInForm;

    /**
     * Obtient la valeur de la propriété signInForm.
     * 
     * @return
     *     possible object is
     *     {@link SignInForm }
     *     
     */
    public SignInForm getSignInForm() {
        return signInForm;
    }

    /**
     * Définit la valeur de la propriété signInForm.
     * 
     * @param value
     *     allowed object is
     *     {@link SignInForm }
     *     
     */
    public void setSignInForm(SignInForm value) {
        this.signInForm = value;
    }

}

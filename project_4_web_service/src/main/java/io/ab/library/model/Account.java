package io.ab.library.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ab.io/library")
@Entity
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String email;
	
	@XmlTransient
	private String password;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="reminder")
	private Boolean reminder;

	/*//bi-directional many-to-one association to Rental
	@JsonIgnore
	@OneToMany(mappedBy="account")
	private List<Rental> rentals;*/

	public Account() {
	}
	
	public Account(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getReminder() {
		return reminder;
	}

	public void setReminder(Boolean reminder) {
		this.reminder = reminder;
	}

	/*public List<Rental> getRentals() {
		return this.rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public Rental addRental(Rental rental) {
		getRentals().add(rental);
		rental.setAccount(this);

		return rental;
	}

	public Rental removeRental(Rental rental) {
		getRentals().remove(rental);
		rental.setAccount(null);

		return rental;
	}*/

}
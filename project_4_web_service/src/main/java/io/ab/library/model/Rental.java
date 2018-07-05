package io.ab.library.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;

import java.util.Date;

/**
 * The persistent class for the rental database table.
 * 
 */
@XmlType(namespace = "http://ab.io/library")
@Entity
public class Rental implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RentalPK id;

	@Temporal(TemporalType.DATE)
	@Column(name = "dead_line")
	private Date deadLine;

	@Column(name = "is_extended")
	private Boolean extended;
	
	@Transient
	private Boolean rentalOver;

	// bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name = "account_id", updatable = false, insertable = false, referencedColumnName = "id")
	private Account account;

	// bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name = "book_id", updatable = false, insertable = false, referencedColumnName = "id")
	private Book book;

	public Rental() {
	}

	public RentalPK getId() {
		return this.id;
	}

	public void setId(RentalPK id) {
		this.id = id;
	}

	public Date getDeadLine() {
		return this.deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public Boolean getExtended() {
		return extended;
	}

	public void setExtended(Boolean extended) {
		this.extended = extended;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Boolean getRentalOver() {
		return rentalOver;
	}

	public void setRentalOver(Boolean rentalOver) {
		this.rentalOver = rentalOver;
	}

}
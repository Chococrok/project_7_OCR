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
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReservationPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reservation_end")
	private Date reservationEnd;

	// bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name = "account_id", updatable = false, insertable = false, referencedColumnName = "id")
	private Account account;

	// bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name = "book_id", updatable = false, insertable = false, referencedColumnName = "id")
	private Book book;

	public Reservation() {
	}
	
	public Reservation(int accountId, int bookId) {
		this.id = new ReservationPK(accountId, bookId);
	}
	
	public Reservation(int accountId, int bookId, Date reservationEnd) {
		this.id = new ReservationPK(accountId, bookId);
		this.reservationEnd = reservationEnd;
	}

	public ReservationPK getId() {
		return this.id;
	}

	public void setId(ReservationPK id) {
		this.id = id;
	}

	public Date getReservationEnd() {
		return reservationEnd;
	}

	public void setReservationEnd(Date reservationEnd) {
		this.reservationEnd = reservationEnd;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
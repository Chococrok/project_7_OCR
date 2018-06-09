package io.ab.library.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;

/**
 * The primary key class for the rental database table.
 * 
 */
@XmlType(namespace = "http://ab.io/library")
@Embeddable
public class ReservationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="account_id", insertable=false, updatable=false)
	private Integer accountId;

	@Column(name="book_id", insertable=false, updatable=false)
	private Integer bookId;

	public ReservationPK() {
	}
	
	public ReservationPK(int accountId, int bookId) {
		this.accountId = accountId;
		this.bookId = bookId;
	}
	
	public Integer getAccountId() {
		return this.accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getBookId() {
		return this.bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReservationPK)) {
			return false;
		}
		ReservationPK castOther = (ReservationPK)other;
		return 
			this.accountId.equals(castOther.accountId)
			&& this.bookId.equals(castOther.bookId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.accountId.hashCode();
		hash = hash * prime + this.bookId.hashCode();
		
		return hash;
	}
}
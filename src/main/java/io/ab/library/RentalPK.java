package io.ab.library;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rental database table.
 * 
 */
@Embeddable
public class RentalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="account_id", insertable=false, updatable=false)
	private Integer accountId;

	@Column(name="book_id", insertable=false, updatable=false)
	private Integer bookId;

	public RentalPK() {
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
		if (!(other instanceof RentalPK)) {
			return false;
		}
		RentalPK castOther = (RentalPK)other;
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
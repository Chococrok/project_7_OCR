package io.ab.library.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the book database table.
 * 
 */
@XmlType(namespace = "http://ab.io/library")
@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer copy;

	private String name;

	//bi-directional many-to-one association to Author
	@ManyToOne
	private Author author;

	//bi-directional many-to-one association to Publisher
	@ManyToOne
	private Publisher publisher;

	//bi-directional many-to-many association to Tag
	@ManyToMany
	@JoinTable(
		name="book_tag"
		, joinColumns={
			@JoinColumn(name="book_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="tag_id")
			}
		)
	private List<Tag> tags;

	//bi-directional many-to-one association to Rental
	@JsonIgnore
	@OneToMany(mappedBy="book", fetch=FetchType.LAZY)
	private List<Rental> rentals;

	public Book() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCopy() {
		return this.copy;
	}

	public void setCopy(Integer copy) {
		this.copy = copy;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Rental> getRentals() {
		return this.rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public Rental addRental(Rental rental) {
		getRentals().add(rental);
		rental.setBook(this);

		return rental;
	}

	public Rental removeRental(Rental rental) {
		getRentals().remove(rental);
		rental.setBook(null);

		return rental;
	}

}
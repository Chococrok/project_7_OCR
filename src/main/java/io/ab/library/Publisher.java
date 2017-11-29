package io.ab.library;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the publisher database table.
 * 
 */
@Entity
public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Book
	@JsonIgnore
	@OneToMany(mappedBy="publisher")
	private List<Book> books;

	public Publisher() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setPublisher(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setPublisher(null);

		return book;
	}

}
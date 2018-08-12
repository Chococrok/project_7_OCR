package io.ab.library.webapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import io.ab.library.webapp.service.pojo.BookPOJO;
import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.Tag;

@Controller
@InterceptorRef("searchStack")
public class SearchAction extends LibraryActionSupport {

	private static final String TAG_FR = "Tag";
	private static final String TAG = "tag";
	private static final String PUBLISHER_FR = "Editeur";
	private static final String PUBLISHER = "publisher";
	private static final String AUTHOR_FR = "Auteur";
	private static final String AUTHOR = "author";
	private static final String BOOK_FR = "Livre";
	private static final String BOOK = "book";
	private static final String SEARCH = "search";

	private Map<String, Object> session;
	private String search;
	private SearchType lastSearchType;
	private String lastSearchTypeFR;
	private List<Tag> tags;

	private enum SearchType {
		TAG("tag"), PUBLISHER("publisher"), AUTHOR("author"), BOOK("book");

		private final String name;

		private SearchType(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}

	@Override
	public String execute() throws Exception {
		this.lastSearchType = SearchType.BOOK;
		this.lastSearchTypeFR = BOOK_FR;
		this.page = SEARCH;
		
		return SUCCESS;
	}

	@Action(value = SEARCH + "/" + BOOK, results = { @Result(location = SEARCH + ".jsp") })
	public String searchBook() throws Exception {
		this.page = SEARCH;
		this.lastSearchType = SearchType.BOOK;
		this.lastSearchTypeFR = BOOK_FR;
		this.setBooksBySearchType();
		
		return SUCCESS;
	}

	@Action(value = SEARCH + "/" + AUTHOR, results = { @Result(location = SEARCH + ".jsp") })
	public String searchAuthor() throws Exception {
		this.page = SEARCH;
		this.lastSearchType = SearchType.AUTHOR;
		this.lastSearchTypeFR = AUTHOR_FR;
		this.setBooksBySearchType();
		
		return SUCCESS;
	}

	@Action(value = SEARCH + "/" + PUBLISHER, results = { @Result(location = SEARCH + ".jsp") })
	public String searchPublisher() throws Exception {
		this.page = SEARCH;
		this.lastSearchType = SearchType.PUBLISHER;
		this.lastSearchTypeFR = PUBLISHER_FR;
		this.setBooksBySearchType();
		
		return SUCCESS;
	}

	@Action(value = SEARCH + "/" + TAG, results = { @Result(location = SEARCH + ".jsp") })
	public String searchTag() throws Exception {
		this.page = SEARCH;
		this.lastSearchType = SearchType.TAG;
		this.lastSearchTypeFR = TAG_FR;
		this.setBooksBySearchType();

		return SUCCESS;
	}

	private void setBooksBySearchType() {
		switch (this.lastSearchType) {
		case TAG:
			this.books = this.bookService.modelsToPOJOs(this.bookService.searchBooksByTagName(search));
			break;
		case BOOK:
			this.books = this.bookService.modelsToPOJOs(this.bookService.searchBooksByBookName(search));
			break;
		case PUBLISHER:
			this.books = this.bookService.modelsToPOJOs(this.bookService.searchBooksByPublisherName(search));
			break;
		case AUTHOR:
			this.books = this.bookService.modelsToPOJOs(this.bookService.searchBooksByAuthorName(search));
			break;
		}

		Account account = (Account) super.session.get("account");

		if (account != null) {
			this.rentals = this.rentalService.getRentalsByUser(account.getId());
			this.bookService.checkBookedByUser(this.books, account);
			this.bookService.checkRentedByUser(this.books, account);
		}
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getLastSearchType() {
		return lastSearchType.toString();
	}

	public void setLastSearchType(String lastSearchType) {
		this.lastSearchType = SearchType.valueOf(lastSearchType.toUpperCase());
	}

	public String getLastSearchTypeFR() {
		return lastSearchTypeFR;
	}

	public void setLastSearchTypeFR(String lastSearchTypeFR) {
		this.lastSearchTypeFR = lastSearchTypeFR;
	}
}

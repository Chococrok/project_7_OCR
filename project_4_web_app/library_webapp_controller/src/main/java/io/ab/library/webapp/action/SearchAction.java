package io.ab.library.webapp.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import io.ab.library.webapp.dto.BookDTO;
import io.ab.library.webapp.wsdl.Tag;

@Controller
@ParentPackage(value ="searchPackage")
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
	
	private String search;
	private String lastSearchType;
	private String lastSearchTypeFR;
	private List<Tag> tags;
		
	@Override
	public String execute() throws Exception {
		this.lastSearchType = BOOK;
		this.lastSearchTypeFR = BOOK_FR;
		this.page = SEARCH;
		return SUCCESS;
	}
	
	@Action(value = SEARCH + "/" + BOOK, results = { @Result(location = SEARCH + ".jsp") })
	public String searchBook() throws Exception {
		this.books = BookDTO.listConverter(this.bookService.searchBooksByBookName(search));
		this.lastSearchType = BOOK;
		this.lastSearchTypeFR = BOOK_FR;
		this.page = SEARCH;
		return SUCCESS;
	}
	
	@Action(value = SEARCH + "/" + AUTHOR, results = { @Result(location = SEARCH + ".jsp") })
	public String searchAuthor() throws Exception {
		this.books = BookDTO.listConverter(this.bookService.searchBooksByAuthorName(search));
		this.lastSearchType = AUTHOR;
		this.lastSearchTypeFR = AUTHOR_FR;
		this.page = SEARCH;
		return SUCCESS;
	}
	
	@Action(value = SEARCH + "/" + PUBLISHER, results = { @Result(location = SEARCH + ".jsp") })
	public String searchPublisher() throws Exception {
		this.books = BookDTO.listConverter(this.bookService.searchBooksByPublisherName(search));
		this.lastSearchType = PUBLISHER;
		this.lastSearchTypeFR = PUBLISHER_FR;
		this.page = SEARCH;
		return SUCCESS;
	}
	
	@Action(value = SEARCH + "/" + TAG, results = { @Result(location = SEARCH + ".jsp") })
	public String searchTag() throws Exception {
		this.books = BookDTO.listConverter(this.bookService.searchBooksByTagName(search));
		this.lastSearchType = TAG;
		this.lastSearchTypeFR = TAG_FR;
		this.page = SEARCH;
		return SUCCESS;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getLastSearchType() {
		return lastSearchType;
	}

	public void setLastSearchType(String lastSearchType) {
		this.lastSearchType = lastSearchType;
	}

	public String getLastSearchTypeFR() {
		return lastSearchTypeFR;
	}

	public void setLastSearchTypeFR(String lastSearchTypeFR) {
		this.lastSearchTypeFR = lastSearchTypeFR;
	}
}

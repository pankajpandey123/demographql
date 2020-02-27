package com.company.demographql.resolver;

import java.util.List;

import com.company.demographql.model.Author;
import com.company.demographql.model.Book;
import com.company.demographql.repository.AuthorRepository;
import com.company.demographql.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	public Query(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public Iterable<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public long countBooks() {
		return bookRepository.count();
	}

	public long countAuthors() {
		return authorRepository.count();
	}
}

package com.company.demographql.resolver;

import java.util.Optional;

import com.company.demographql.error.BookNotFoundException;
import com.company.demographql.model.Author;
import com.company.demographql.model.Book;
import com.company.demographql.repository.AuthorRepository;
import com.company.demographql.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	public Mutation(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public Author newAuthor(String firstName, String lastName) {
		Author author = new Author(firstName, lastName);
		return authorRepository.save(author);
	}

	public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
		Book book = new Book(title, isbn, pageCount, new Author(authorId));
		return bookRepository.save(book);
	}

	public boolean deleteBook(Long bookid) {
		bookRepository.delete(bookid);
		return true;
	}

	public Book updateBookPages(Integer pageCount, Long id) {
		Book bookOp = bookRepository.findOne(id);
		if (bookOp == null) {
			throw new BookNotFoundException("book not found", id);
		}

		bookOp.setPageCount(pageCount);
		return bookRepository.save(bookOp);
	}

}

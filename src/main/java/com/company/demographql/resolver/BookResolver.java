package com.company.demographql.resolver;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.company.demographql.model.Author;
import com.company.demographql.model.Book;
import com.company.demographql.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
@Service 
public class BookResolver implements GraphQLResolver<Book> {

	private AuthorRepository authorRepository;
	 

	public BookResolver(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	public Author getAuthor(Book book) {
		return authorRepository.findOne(book.getAuthor().getId());
	}
}

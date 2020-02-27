package com.company.demographql;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.company.demographql.model.Author;
import com.company.demographql.model.Book;

import com.company.demographql.repository.AuthorRepository;
import com.company.demographql.repository.BookRepository;
import com.company.demographql.resolver.BookResolver;
import com.company.demographql.resolver.Mutation;
import com.company.demographql.resolver.Query;


import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;


@SpringBootApplication
public class DemographqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemographqlApplication.class, args);
	}

	
	@Bean
	GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {

			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clienterros = errors.stream()
						.collect(Collectors.toList());
				List<GraphQLError> errs=new ArrayList<GraphQLError>();
				errs.addAll(clienterros);
				return errs;
			}
		};
	}

	/*ss
	 * @Bean ApplicationRunner init(FoodService foodService) { return args -> {
	 * Stream.of("Pizza", "spam", "eggs", "tomato").forEach(name -> { Food food =
	 * new Food(); food.setName(name); foodService.saveFood(food); }); }; }
	 */

	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Query(bookRepository, authorRepository);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Mutation(bookRepository, authorRepository);
	}

	@Bean
	CommandLineRunner runner(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {
			Author author = new Author("Ram", "mano");
			authorRepository.save(author);
			bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));

		};
	}
}

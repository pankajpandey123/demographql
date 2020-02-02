package com.company.demographql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.company.demographql.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}

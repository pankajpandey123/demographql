package com.company.demographql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.company.demographql.model.Author;

public interface AuthorRepository extends  CrudRepository<Author, Long> {

}

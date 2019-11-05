package com.BooksPlace.BooksPlace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BooksPlace.BooksPlace.Model.Livro;

public interface Livros extends JpaRepository<Livro, Long>{

}

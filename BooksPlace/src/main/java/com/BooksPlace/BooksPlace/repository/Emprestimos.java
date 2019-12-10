package com.BooksPlace.BooksPlace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BooksPlace.BooksPlace.Model.Emprestimo;

public interface Emprestimos extends JpaRepository<Emprestimo, Long> {

}

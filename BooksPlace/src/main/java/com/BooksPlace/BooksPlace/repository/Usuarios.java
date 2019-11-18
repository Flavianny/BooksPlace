package com.BooksPlace.BooksPlace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BooksPlace.BooksPlace.Model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>{

}

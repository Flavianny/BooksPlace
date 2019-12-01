package com.BooksPlace.BooksPlace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BooksPlace.BooksPlace.Model.Usuario;

/**
 * Interface responsável por fornecer os metodos de persistência para entidade usuario.
 */
public interface Usuarios extends JpaRepository<Usuario, Long>{

}

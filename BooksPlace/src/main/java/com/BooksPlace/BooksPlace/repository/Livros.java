package com.BooksPlace.BooksPlace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BooksPlace.BooksPlace.Model.Livro;

/**
 * Interface responsável por fornecer os metodos de persistência para entidade livro.
 */
public interface Livros extends JpaRepository<Livro, Long>{
	
//	public List<Livro> findByTituloContainingOrAutorContainingOrGeneroContaining(String textoFiltro);
	
	public List<Livro> findByTituloContainingOrAutoresContaining(String textoFiltro, String textoFiltro2);
	//public List<Livro> findByGeneroContaining(String genero);
}

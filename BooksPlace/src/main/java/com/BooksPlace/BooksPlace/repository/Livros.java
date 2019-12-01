package com.BooksPlace.BooksPlace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BooksPlace.BooksPlace.Model.Livro;

/**
 * Interface responsável por fornecer os metodos de persistência para entidade livro.
 */
public interface Livros extends JpaRepository<Livro, Long>{
<<<<<<< HEAD
	public List<Livro> findByTituloContainingOrAutorContainingOrGeneroContaining(String textoFiltro1, String textoFiltro2, String textoFiltro3);
=======
	
//	public List<Livro> findByTituloContainingOrAutorContainingOrGeneroContaining(String textoFiltro);
	
//	public List<Livro> findByTituloContainingOrAutoresContaining(String textoFiltro, String textoFiltro2);
	//public List<Livro> findByGeneroContaining(String genero);
>>>>>>> 3421a8dbc9ab4766be6fbf2522d4d18f1afe95c8
}

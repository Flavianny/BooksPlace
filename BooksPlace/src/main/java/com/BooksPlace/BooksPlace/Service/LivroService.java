package com.BooksPlace.BooksPlace.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.BooksPlace.BooksPlace.Model.Livro;
import com.BooksPlace.BooksPlace.repository.Livros;
import com.BooksPlace.BooksPlace.repository.filter.LivroFilter;

public class LivroService {
	
	@Autowired
	private Livros livros;
	
//	public ArrayList<Livro> buscar(LivroFilter filtro){
//		String descricao = filtro.getTextoFiltro() == null ? "%" : filtro.getTextoFiltro();
//		return livros.findByTituloContainingOrAutoresContaining(textoFiltro, textoFiltro2);
//	}

}

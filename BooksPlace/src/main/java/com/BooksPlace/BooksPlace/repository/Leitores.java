package com.BooksPlace.BooksPlace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BooksPlace.BooksPlace.Model.Leitor;

/**
 * Interface responsável por fornecer os metodos de persistência para entidade leitores.
 */
public interface Leitores extends JpaRepository<Leitor, Long>{

	public List<Leitor> findByNomeContainingOrCpfContaining(String textoFiltro1, String textoFiltro2);
}
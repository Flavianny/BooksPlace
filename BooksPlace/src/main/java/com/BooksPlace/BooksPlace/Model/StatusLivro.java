package com.BooksPlace.BooksPlace.Model;

/**
 * Classe utilizada para representar o status de um livro. 
 * @author flavianny
 *
 */
public enum StatusLivro {
	
	DISPONIVEL("Disponível"),
	INDISPONIVEL("Indisponível");
	
	private String descricao;
	
	private StatusLivro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}

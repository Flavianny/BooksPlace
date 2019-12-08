package com.BooksPlace.BooksPlace.Model;

/**
 * Classe utilizada para representar o status de um livro. 
 * @author flavianny
 *
 */
public enum StatusEmprestimo {
	
	DISPONIVEL("Em vigor"),
	INDISPONIVEL("Atrazado");
	
	private String descricao;
	
	private StatusEmprestimo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}

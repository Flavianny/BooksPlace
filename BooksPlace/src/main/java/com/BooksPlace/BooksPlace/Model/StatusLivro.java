package com.BooksPlace.BooksPlace.Model;

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

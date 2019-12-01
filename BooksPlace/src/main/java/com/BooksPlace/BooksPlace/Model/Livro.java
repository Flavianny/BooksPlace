package com.BooksPlace.BooksPlace.Model;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Classe utilizada para representar a entidade livro que será manipulada 
 * dentro do sistema.
 * @author flavianny
 *
 */

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = " O campo Título é obrigatório")
	@Size(max = 50, message = "O Título não deve obter mais de 50 caracteres")
	private String titulo;
	
	@NotEmpty(message = "O campo Descrição é obrigatória")
	@Size(max = 60, message = "A Descrição não deve obter mais de 60 caracteres")
	private String descricao;
	
	@NotEmpty(message = "O campo Gerero é obrigatório")
	@Size(max = 60, message = "O Genero não deve obter mais de 60 caracteres")
	private String genero;
	
	/**
	 * @deprecated Essa variável não deveria ser utilizada com o tipo String,
	 * e sim com o tipo int.
	 */
	@NotEmpty(message = "O campo Ano é obrigatório")
	@Size(max = 4, message = "Ano não deve obter mais de 4 caracteres")
	private String ano;
	
	@NotEmpty(message = "O campo Autor é obrigatório")
	@Size(max = 40, message = "O Autor não deve obter mais de 40 caracteres")
	private ArrayList<String> autores;
	
	@NotEmpty(message = "O campo ISBN é obrigatório")
	@Size(max = 40, message = "O ISBN não deve obter mais de 40 caracteres")
	private String isbn;
	
	private int exemplares;
	
	private StatusLivro status;
	
	private byte[] capa;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public ArrayList<String> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<String> autores) {
		this.autores = autores;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getExemplares() {
		return exemplares;
	}

	public void setExemplares(int exemplares) {
		this.exemplares = exemplares;
	}

	public byte[] getCapa() {
		return capa;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}


	public boolean isIndisponivel() {
		return StatusLivro.INDISPONIVEL.equals(this.status); 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + Arrays.hashCode(capa);
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + exemplares;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (!Arrays.equals(capa, other.capa))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (exemplares != other.exemplares)
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}

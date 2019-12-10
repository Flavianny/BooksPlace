package com.BooksPlace.BooksPlace.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmprestimo;
	
	private Date devolucao;
	
	@ManyToOne
	@JoinColumn(name = "id_leitor")
	private Leitor leitor;
	
	@ManyToOne
	@JoinColumn(name = "id_livro")
	private Livro livro;



	private String cpfLeitor;

	
	//gambiarra
	public String getCpfLeitor() {
		return cpfLeitor;
	}

	public void setCpfLeitor(String cpfLeitor) {
		this.cpfLeitor = cpfLeitor;
	}

	public long getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(long idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Date getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
	
	
	
	
	
	
	
	
	
}

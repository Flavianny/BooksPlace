package com.BooksPlace.BooksPlace.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmprestimo;
	
	@Temporal(TemporalType.DATE)
	private Date devolucao;
	
	@ManyToOne
	@JoinColumn(name = "id_leitor")
	private Leitor leitor;
	
	@ManyToOne
	@JoinColumn(name = "id_livro")
	private Livro livro;



	//gambiarra
	private String cpfLeitor;



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



	public String getCpfLeitor() {
		return cpfLeitor;
	}



	public void setCpfLeitor(String cpfLeitor) {
		this.cpfLeitor = cpfLeitor;
	}

	
	
	
	
	
	
	
	
	
	
	
}

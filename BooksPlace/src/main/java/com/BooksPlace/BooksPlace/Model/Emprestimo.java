package com.BooksPlace.BooksPlace.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmprestimo;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date devolucao;
	
//	@ManyToOne
//	@JoinColumn(name = "id_leitor")
//	private Leitor leitor;
//	
//	@ManyToOne
//	@JoinColumn(name = "id_livro")
//	private Livro livro;



	//gambiarra
	private String cpfLeitor;
	private String tituloLivro;
	
	
	
	
	
	
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
	public String getCpfLeitor() {
		return cpfLeitor;
	}
	public void setCpfLeitor(String cpfLeitor) {
		this.cpfLeitor = cpfLeitor;
	}
	public String getTituloLivro() {
		return tituloLivro;
	}
	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfLeitor == null) ? 0 : cpfLeitor.hashCode());
		result = prime * result + ((devolucao == null) ? 0 : devolucao.hashCode());
		result = prime * result + (int) (idEmprestimo ^ (idEmprestimo >>> 32));
		result = prime * result + ((tituloLivro == null) ? 0 : tituloLivro.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (cpfLeitor == null) {
			if (other.cpfLeitor != null)
				return false;
		} else if (!cpfLeitor.equals(other.cpfLeitor))
			return false;
		if (devolucao == null) {
			if (other.devolucao != null)
				return false;
		} else if (!devolucao.equals(other.devolucao))
			return false;
		if (idEmprestimo != other.idEmprestimo)
			return false;
		if (tituloLivro == null) {
			if (other.tituloLivro != null)
				return false;
		} else if (!tituloLivro.equals(other.tituloLivro))
			return false;
		return true;
	}

	
	
	

	

	
	
	
	
	
	
	
	
	
	
	
}

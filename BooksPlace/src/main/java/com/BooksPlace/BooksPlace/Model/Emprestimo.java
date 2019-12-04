package com.BooksPlace.BooksPlace.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmprestimo;
	
	private String cpfLeitor;
	private long idLivro;
	private Date devolucao;
	
	@Enumerated(EnumType.STRING)
	private StatusEmprestimo status;
	
	public long getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(long idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public String getCpfLeitor() {
		return cpfLeitor;
	}

	public void setCpfLeitor(String cpfLeitor) {
		this.cpfLeitor = cpfLeitor;
	}

	public long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(long idLivro) {
		this.idLivro = idLivro;
	}

	public Date getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
	}

	public StatusEmprestimo getStatus() {
		return status;
	}

	public void setStatus(StatusEmprestimo status) {
		this.status = status;
	}
	
	public boolean isIndisponivel() {
		return StatusEmprestimo.INDISPONIVEL.equals(this.status);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfLeitor == null) ? 0 : cpfLeitor.hashCode());
		result = prime * result + ((devolucao == null) ? 0 : devolucao.hashCode());
		result = prime * result + (int) (idEmprestimo ^ (idEmprestimo >>> 32));
		result = prime * result + (int) (idLivro ^ (idLivro >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (idLivro != other.idLivro)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	
	
	
}

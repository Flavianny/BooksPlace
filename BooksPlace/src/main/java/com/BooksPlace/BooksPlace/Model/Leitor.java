package com.BooksPlace.BooksPlace.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

/**
 * Classe utilizada para representar a entidade leitor que será manipulada 
 * dentro do sistema.
 * @author airla
 *
 */

@Entity
public class Leitor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	
	
	@OneToMany(mappedBy = "leitor")
	private List<Emprestimo> emprestimos;
	
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(max = 100, message = "O nome não pode conter mais de 100 caracteres")
	private String nome;
	
	@NotBlank(message = "CPF é obrigatório")
	@CPF(message="CPF inválido")
	private String cpf;	
	
	@NotBlank(message = "Telefone é obrigatório")
	private String telefone;
	
	@NotBlank(message = "Cidade é obrigatória")
	private String cidade;
	
	@NotBlank(message = "Endereço é obrigatório")
	private String endereco;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Leitor other = (Leitor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
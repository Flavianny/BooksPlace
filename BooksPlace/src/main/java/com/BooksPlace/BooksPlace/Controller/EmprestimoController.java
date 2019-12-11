package com.BooksPlace.BooksPlace.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BooksPlace.BooksPlace.Model.Emprestimo;
import com.BooksPlace.BooksPlace.Model.Leitor;
import com.BooksPlace.BooksPlace.Model.Livro;
import com.BooksPlace.BooksPlace.repository.Emprestimos;
import com.BooksPlace.BooksPlace.repository.Leitores;
import com.BooksPlace.BooksPlace.repository.Livros;

@Controller
public class EmprestimoController {
	
	
	@Autowired
	private Leitores leitores;
	
	
	@Autowired
	private Livros livros;
	
	@Autowired
	private Emprestimos emprestimos;
	
	@RequestMapping("/livros/emprestimo/{id}")
	public ModelAndView emprestimo(@PathVariable("id") Livro livro) {
		ModelAndView mv = new ModelAndView("Emprestimo");
		mv.addObject(livro);
		mv.addObject("todosLeitores", leitores.findAll());
		return mv; 
	}
	
	
	
	
	@RequestMapping("/emprestimos")
	public ModelAndView buscarLivro() {
		
		List<Emprestimo> todosEmprestimos = emprestimos.findAll();
		
		ModelAndView mv = new ModelAndView("ListagemDeEmprestimos");
		mv.addObject("emprestimos", todosEmprestimos);
		return mv; 
	}

	
	@PostMapping("**/efetuarEmprestimo/{id}")
	public ModelAndView efetuarEmprestimo(@PathVariable("id") Long id,  Emprestimo emprestimo) {
		
		Leitor leitor = leitores.findByCpf(emprestimo.getCpfLeitor());
		Livro livro = livros.findById(id).get();

//		usado quando mapeado
//		emprestimo.setLeitor(leitor);
//		emprestimo.setLivro(livro);
		
//		gambiarra (está sendo salvo 2 strings (cpfLeitor e tituloLivro) obs: olhar model
		emprestimo.setTituloLivro(livro.getTitulo());
		
//		decrementar a variavel exemplares de livro

		emprestimos.save(emprestimo);
		
		
		ModelAndView mv = new ModelAndView("Emprestimo");
		mv.addObject(livro);
		mv.addObject("mensagem", "Empréstimo efetuado com sucesso!");
		return mv; 
	}
	
}
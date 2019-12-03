package com.BooksPlace.BooksPlace.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BooksPlace.BooksPlace.Model.Livro;
import com.BooksPlace.BooksPlace.repository.Leitores;

@Controller
public class EmprestimoController {
	
	
	@Autowired
	private Leitores leitores;
	
	@RequestMapping("/livros/emprestimo/{id}")
	public ModelAndView emprestimo(@PathVariable("id") Livro livro) {
		ModelAndView mv = new ModelAndView("Emprestimo");
		mv.addObject(livro);
		mv.addObject("todosLeitores", leitores.findAll());
		return mv; 
	}

}

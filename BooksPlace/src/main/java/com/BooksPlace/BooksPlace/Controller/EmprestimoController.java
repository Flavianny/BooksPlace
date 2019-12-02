package com.BooksPlace.BooksPlace.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BooksPlace.BooksPlace.Model.Livro;

@Controller
public class EmprestimoController {
	
	@RequestMapping("/livros/emprestimo/{id}")
	public ModelAndView emprestimo(@PathVariable("id") Livro livro) {
		ModelAndView mv = new ModelAndView("Emprestimo");
		mv.addObject(livro);
		return mv; 
	}

}

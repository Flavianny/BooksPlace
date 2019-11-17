package com.BooksPlace.BooksPlace.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.BooksPlace.BooksPlace.Model.Livro;
import com.BooksPlace.BooksPlace.Model.StatusLivro;
import com.BooksPlace.BooksPlace.repository.Livros;

@Controller
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private Livros livros;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroLivro");
		mv.addObject(new Livro());
		return mv; 
	}
	
	@RequestMapping
	public String buscarLivro() {
		return "BuscarLivros";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Livro livro, Errors erros) {	
		ModelAndView mv = new ModelAndView("CadastroLivro");
		if (erros.hasErrors()) {
			return mv;
		}
		livros.save(livro);
		mv.addObject("mensagem", "Livro salvo com sucesso");
		return mv;	
	}
	
	@ModelAttribute("todosStatusLivro")
	public List<StatusLivro> todosStatusLivro() {
		return Arrays.asList(StatusLivro.values());
	}
}

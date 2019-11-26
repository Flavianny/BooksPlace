package com.BooksPlace.BooksPlace.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmprestimoController {
	
	@RequestMapping("/livros/emprestimo")
	public String emprestimo() {
		return "Emprestimo"; 
	}

}

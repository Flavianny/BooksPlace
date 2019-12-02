package com.BooksPlace.BooksPlace.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {

	@RequestMapping("/inicio")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("Inicio");
		return mv; 
	}
}

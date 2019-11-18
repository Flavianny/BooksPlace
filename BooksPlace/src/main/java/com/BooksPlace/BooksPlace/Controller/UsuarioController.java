package com.BooksPlace.BooksPlace.Controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.BooksPlace.BooksPlace.Model.Estado;
import com.BooksPlace.BooksPlace.Model.Usuario;
import com.BooksPlace.BooksPlace.repository.Usuarios;

@Controller
@RequestMapping("/cadastrousuario")
public class UsuarioController {
	@Autowired
	private Usuarios usuarios;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroUsuario");
		mv.addObject(new Usuario());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Usuario usuario, Errors errors) {
		//TODO: Salvar no banco de dados
		
		ModelAndView mv = new ModelAndView("CadastroUsuario");	
		
		if(errors.hasErrors()) {
			return mv;
		}
		
		usuarios.save(usuario);
		mv.addObject("mensagem", "Usuário salvo com sucesso!");
		return mv;
	}
	
	@ModelAttribute("estados")
	public java.util.List<Object> estado(){
		return Arrays.asList(Estado.values());
	}

}

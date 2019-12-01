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

import com.BooksPlace.BooksPlace.Model.Estado;
import com.BooksPlace.BooksPlace.Model.Usuario;
import com.BooksPlace.BooksPlace.repository.Usuarios;

/**
 * Classe utilizada para controlar as requisições feitas para entidade usuário.
 * @author airla
 *
 */
@Controller
@RequestMapping("/leitores")
public class UsuarioController {
	@Autowired
	private Usuarios usuarios;
	
	
//	busca todos os leitores 
//	OBS: adicionar a filtragem
	@RequestMapping
	public ModelAndView buscarLeitor() {
		
		List<Usuario> todosUsuarios = usuarios.findAll();
		ModelAndView mv = new ModelAndView("ListaDeLeitores");
		mv.addObject("leitores", todosUsuarios);
		return mv;
	}
	
	
	
	/**
	 * Método novo
	 * Responsável por atender a requisição ("/novo") a qual 
	 * exibirá uma view com o formulario de cadastro de usuário.
	 * @author airla
	 */
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroUsuario");
		mv.addObject(new Usuario());
		return mv;
	}
	
	/**
	 * Método salvar
	 * Utilizado para salvar um usuário no banco de dados.
	 * @param usuario usuário que contém os dados a serem salvos.
	 * @param errors representa os possíveis erros de validação do usuário.
	 * @author airla
	 */
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
	
	/**
	 * Método estado
	 * Utilizado para retornar os estado do Brasil definidos pelo Enum Estado.
	 * @return object estados disponíveis.
	 * @author airla
	 */
	@ModelAttribute("estados")
	public java.util.List<Object> estado(){
		return Arrays.asList(Estado.values());
	}

}

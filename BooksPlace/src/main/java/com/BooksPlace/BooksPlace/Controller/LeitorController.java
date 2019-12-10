package com.BooksPlace.BooksPlace.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.BooksPlace.BooksPlace.Model.Estado;
import com.BooksPlace.BooksPlace.Model.Leitor;
import com.BooksPlace.BooksPlace.repository.Leitores;
import com.BooksPlace.BooksPlace.repository.filter.LeitorFilter;

/**
 * Classe utilizada para controlar as requisições feitas para entidade leitor.
 * @author airla
 *
 */
@Controller
@RequestMapping("/leitores")
public class LeitorController {
	@Autowired
	private Leitores leitores;
	
	private static final String CADASTRO_VIEW = "CadastroLeitor";
	
//	busca todos os leitores 
//	OBS: adicionar a filtragem
	@RequestMapping
	public ModelAndView buscarLeitor(@ModelAttribute("filtro") LeitorFilter filtro) {
		
		List<Leitor> todosLeitores = filtro.getTextoFiltro() == null ? leitores.findAll() : leitores.findByNomeContainingOrCpfContaining(filtro.getTextoFiltro(), filtro.getTextoFiltro());
		
		ModelAndView mv = new ModelAndView("ListaDeLeitores");
		mv.addObject("leitores", todosLeitores);
		return mv;
	}
	
	/**
	 * Método novo
	 * Responsável por atender a requisição ("/novo") a qual 
	 * exibirá uma view com o formulario de cadastro de leitor.
	 * @author airla
	 */
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Leitor());
		return mv;
	}
	
	/**
	 * Método salvar
	 * Utilizado para salvar um leitor no banco de dados.
	 * @param leitor leitor que contém os dados a serem salvos.
	 * @param errors representa os possíveis erros de validação do leitor.
	 * @author airla
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Leitor leitor, Errors errors) {
		//TODO: Salvar no banco de dados
		
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);	
		
		if(errors.hasErrors()) {
			return mv;
		}
		
		leitores.save(leitor);
		mv.addObject("mensagem", "Leitor salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.POST)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		leitores.deleteById(codigo);
		attributes.addFlashAttribute("mensagem", "Leitor excluído com sucesso!");
		return "redirect:/leitores";
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Leitor leitor) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(leitor);
		return mv;
	}
	
	
//	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
//	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
//		Leitor leitor = null;
//		for(Leitor l: leitores.findAll()) {
//			if(l.getCodigo() == codigo) {
//				leitor = l;
//			}
//		}
//		leitores.delete(leitor);
//		attributes.addFlashAttribute("mensagem", "Leitor excluído com sucesso!");
//		return "redirect:/leitores";
//	}
	
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
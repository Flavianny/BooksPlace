package com.BooksPlace.BooksPlace.Controller;
<<<<<<< HEAD

import java.util.Arrays;
import java.util.List;

=======
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
>>>>>>> 3421a8dbc9ab4766be6fbf2522d4d18f1afe95c8
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
import org.springframework.web.servlet.ModelAndView;

=======
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
>>>>>>> 3421a8dbc9ab4766be6fbf2522d4d18f1afe95c8
import com.BooksPlace.BooksPlace.Model.Livro;
import com.BooksPlace.BooksPlace.Model.StatusLivro;
import com.BooksPlace.BooksPlace.repository.Livros;
import com.BooksPlace.BooksPlace.repository.filter.LivroFilter;
<<<<<<< HEAD

=======
>>>>>>> 3421a8dbc9ab4766be6fbf2522d4d18f1afe95c8
/**
 * Classe utilizada para controlar as requisições feitas para entidade livro.
 * @author flavianny
 *
 */
@Controller
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private Livros livros;
<<<<<<< HEAD
=======
	private Livro livro;
	
	private StreamedContent imagem;

	public StreamedContent getImagem() {
		return imagem;
	}

	public void setImagem(StreamedContent imagem) {
		this.imagem = imagem;
	}
	
	  public StreamedContent getImagemAtual() throws IOException { FacesContext
		  context = FacesContext.getCurrentInstance(); if (context.getCurrentPhaseId()
		  == PhaseId.RENDER_RESPONSE) { return new DefaultStreamedContent(); } else {
		  return new DefaultStreamedContent(new
		  ByteArrayInputStream(livro.getCapa())); 
		  } 
	  }
>>>>>>> 3421a8dbc9ab4766be6fbf2522d4d18f1afe95c8

	
	/**
	 * Método novo
	 * Responsável por atender a requisição ("/novo") a qual 
	 * exibirá uma view com o formulario de cadastro de livro.
	 * @author flavianny
	 */
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroLivro");
		mv.addObject(new Livro());
		return mv; 
	}
	
	/**
	 * Método buscarLivro
	 * Responsável por realizar a busca de todos os livros na 
	 * base de dados.
	 * @return ModelAndView retorna o objeto com a listagem.
	 * @author mycaell
	 */
	@RequestMapping
	public ModelAndView buscarLivro(@ModelAttribute("filtro") LivroFilter filtro) {
		
<<<<<<< HEAD
		List<Livro> todosLivros = filtro.getTextoFiltro() == null ? livros.findAll() : livros.findByTituloContainingOrAutorContainingOrGeneroContaining(filtro.getTextoFiltro(),filtro.getTextoFiltro(),filtro.getTextoFiltro());
		
		ModelAndView mv = new ModelAndView("PesquisaDeLivros");
		mv.addObject("livros", todosLivros);
=======
//		List<Livro> todosLivros = filtro.getTextoFiltro() == null ? livros.findAll() : livros.findByTituloContainingOrAutorContainingOrGeneroContaining(filtro.getTextoFiltro());
//		List<Livro> todosLivros = filtro.getTextoFiltro() == null ? livros.findAll() : livros.findByTituloContainingOrAutoresContaining(filtro.getTextoFiltro(), filtro.getTextoFiltro() );
		
//		String  autor = filtro.getAutor() == null ? "%" : filtro.getAutor();
//		String  genero = filtro.getGenero() == null ? "%" : filtro.getGenero();
//		List<Livro> todosLivros = livros.findByTituloContainingOrAutorContaining(titulo, autor);
//		List<Livro> todosLivros = livros.findByTituloContaining(titulo);
		
		ModelAndView mv = new ModelAndView("PesquisaDeLivros");
		mv.addObject("livros", livros);
>>>>>>> 3421a8dbc9ab4766be6fbf2522d4d18f1afe95c8
		return mv; 
	}
	
	/**
	 * Método salvar
	 * Utilizado para salvar um livro no banco de dados.
	 * @param livro livro que contém os dados a serem salvos.
	 * @param errors representa os possíveis erros de validação do livro.
	 * @author flavianny
	 */
	@RequestMapping(method = RequestMethod.POST)
<<<<<<< HEAD
	public ModelAndView salvar(@Validated Livro livro, Errors erros) {	
=======
	public ModelAndView salvar(@RequestParam("file") MultipartFile file, @Validated Livro livro, Errors erros) {	
>>>>>>> 3421a8dbc9ab4766be6fbf2522d4d18f1afe95c8
		ModelAndView mv = new ModelAndView("CadastroLivro");
		if (erros.hasErrors()) {
			return mv;
		}
<<<<<<< HEAD
=======
		byte[] capa;
		try {
			capa = file.getBytes();
			livro.setCapa(capa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//uploadImagemLivro(file);
>>>>>>> 3421a8dbc9ab4766be6fbf2522d4d18f1afe95c8
		livros.save(livro);
		mv.addObject("mensagem", "Livro salvo com sucesso");
		return mv;	
	}
	
	/**
	 * Método todosStatusLivro
	 * Utilizado para retornar os status do livro definidos pelo Enum StatusLivro.
	 * @return object status do livro disponíveis.
	 * @author flavianny
	 */
	@ModelAttribute("todosStatusLivro")
	public List<StatusLivro> todosStatusLivro() {
		return Arrays.asList(StatusLivro.values());
	}
}

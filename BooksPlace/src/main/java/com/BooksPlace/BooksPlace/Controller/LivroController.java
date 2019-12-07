package com.BooksPlace.BooksPlace.Controller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.primefaces.model.StreamedContent;
import com.BooksPlace.BooksPlace.Model.Livro;
import com.BooksPlace.BooksPlace.Model.StatusLivro;
import com.BooksPlace.BooksPlace.repository.Livros;
import com.BooksPlace.BooksPlace.repository.filter.LivroFilter;
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
	private Livro livro;
	
		
	  public StreamedContent ImagemAtual() throws IOException { 
		  //return imagem = (StreamedContent) new ByteArrayResource(livro.getCapa());
		  return null;
	  }
	  
//	  public BufferedImage getImagemAtual() {
////		  return (StreamedContent) new ImageIcon(livro.getCapa()).getImage();
////		  MultipartFile  file = (MultipartFile) new ByteArrayInputStream(livro.getCapa());
////		  return file;
//		  try {
//			  //recupera a imagem do banco usando a entidade livro, poderia ser
//			  // qualquer byte para a classe ImageIO ler.
//			  img = ImageIO.read(new ByteArrayInputStream(livro.getCapa()));
//			  ImageIO.write(img, "png", new File("/tmp/mypng.png"));
//			  return img;
//			  } catch (IOException e) {
//			  e.printStackTrace();
//			  }
//		return null;
//	  }
	
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
		
		List<Livro> todosLivros = filtro.getTextoFiltro() == null ? livros.findAll() : livros.findByTituloContainingOrGeneroContaining(filtro.getTextoFiltro(), filtro.getTextoFiltro());
		
		ModelAndView mv = new ModelAndView("PesquisaDeLivros");
		mv.addObject("livros", todosLivros);
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
	public ModelAndView salvar(@RequestParam("file") MultipartFile file, @Validated Livro livro, Errors erros) {	
		ModelAndView mv = new ModelAndView("CadastroLivro");
		if (erros.hasErrors()) {
			return mv;
		}
		try {
			byte[] capa;
			capa = file.getBytes();
			livro.setCapa(capa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//uploadImagemLivro(file);
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
package com.BooksPlace.BooksPlace.Controller;

import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.BooksPlace.BooksPlace.Model.Livro;
import com.BooksPlace.BooksPlace.repository.Livros;

@Controller
public class EmprestimoController {
	
	@Autowired
	private Livros livros;
	private Livro livro;
	
	private StreamedContent imagem;

	public StreamedContent getImagem() {
		return imagem;
	}

	public void setImagem(StreamedContent imagem) {
		this.imagem = imagem;
	}
	
	@RequestMapping("/livros/emprestimo/{id}")
	public ModelAndView emprestimo(@PathVariable("id") Livro livro) {
		ModelAndView mv = new ModelAndView("Emprestimo");
		this.livro = livro;
		mv.addObject(livro);
		return mv; 
	}
	
	@RequestMapping(value="imagem", produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public String imagem() throws IOException {
//		for(Livro l: livros.findAll()) {
//			if(l.getId() == id) livro = l;
//		}
		RenderedImage img = ImageIO.read(new ByteArrayInputStream(livro.getCapa()));
		ImageIO.write(img, "png", new File("/tmp/imagem.png"));  
	    return "/tmp/imagem.png";    
	}

}
